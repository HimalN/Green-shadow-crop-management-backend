package lk.ijse.Green_shadow_crop_management_backend.controller;

import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedLogErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.LogStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.LogDTO;
import lk.ijse.Green_shadow_crop_management_backend.exception.LogNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.LogService;
import lk.ijse.Green_shadow_crop_management_backend.util.AppUtil;
import lk.ijse.Green_shadow_crop_management_backend.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/log")
public class LogController {
    static Logger logger =  LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(
            @RequestPart("logCode") String logCode,
            @RequestPart ("logDate") String logDate,
            @RequestPart ("details") String details,
            @RequestPart ("observedImage") MultipartFile observedImage,
            @RequestPart ("fieldCode") String fieldCode,
            @RequestPart ("cropCode") String cropCode,
            @RequestPart ("staffId") String staffId
    ){
        String base64LogImage = "";
        try{
            byte[] imageBytes = observedImage.getBytes();
            base64LogImage = AppUtil.picToBase64(imageBytes);

            if (!RegexProcess.logIdMatcher(logCode)) {
                logger.info("Log ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            LogDTO logDTO = new LogDTO();
            logDTO.setLogCode(logCode);
            logDTO.setLogDate(logDate);
            logDTO.setDetails(details);
            logDTO.setObservedImage(base64LogImage);
            logDTO.setFieldCode(fieldCode);
            logDTO.setCropCode(cropCode);
            logDTO.setStaffId(staffId);
            logService.saveLog(logDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.info("Data persist error");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{logId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public LogStatus getSelectedLog(@PathVariable ("logId") String logId) {
        if (!RegexProcess.logIdMatcher(logId)) {
            return new SelectedLogErrorStatus(1, "Log ID is not valid");
        }
        return logService.getLog(logId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogDTO> getAllLogs() {
        return logService.getAllLogs();
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @DeleteMapping(value = "/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable ("logId") String logId){
        try {
            if (!RegexProcess.logIdMatcher(logId)) {
                logger.info("Log ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logService.deleteLog(logId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (LogNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateLog(
            @RequestPart ("logCode") String logCode,
            @RequestPart ("logDate") String logDate,
            @RequestPart ("details") String details,
            @RequestPart ("observedImage") MultipartFile observedImage,
            @RequestPart ("fieldCode") String fieldCode,
            @RequestPart ("cropCode") String cropCode,
            @RequestPart ("staffId") String staffId
    ){
        String base64LogImage = "";
        try{
            byte[] imageBytes = observedImage.getBytes();
            base64LogImage = AppUtil.picToBase64(imageBytes);

            if (RegexProcess.logIdMatcher(logCode)) {
                logger.info("Log ID is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            LogDTO logDTO = new LogDTO();
            logDTO.setLogCode(logCode);
            logDTO.setLogDate(logDate);
            logDTO.setDetails(details);
            logDTO.setObservedImage(base64LogImage);
            logDTO.setFieldCode(fieldCode);
            logDTO.setCropCode(cropCode);
            logDTO.setStaffId(staffId);
            logService.saveLog(logDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
