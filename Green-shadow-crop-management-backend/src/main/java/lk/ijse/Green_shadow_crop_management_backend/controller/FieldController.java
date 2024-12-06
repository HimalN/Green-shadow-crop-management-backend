package lk.ijse.Green_shadow_crop_management_backend.controller;

import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedFieldErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.FieldStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.exception.CropNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.FieldService;
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

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("api/v1/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    static Logger logger =  LoggerFactory.getLogger(FieldController.class);


    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extent") String extent,
            @RequestPart("fieldImage1")MultipartFile filedImage1,
            @RequestPart("fieldImage2")MultipartFile filedImage2
    ){
        String base64fieldImage1 = "";
        String base64fieldImage2 = "";
        try {
            byte[] imageBytes1 = filedImage1.getBytes();
            base64fieldImage1 = AppUtil.picToBase64(imageBytes1);

            byte[] imageBytes2 = filedImage2.getBytes();
            base64fieldImage2 = AppUtil.picToBase64(imageBytes2);

            if(!RegexProcess.fieldCodeMatcher(fieldCode)){
                logger.error("Invalid field code");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldNameMatcher(fieldName)){
                logger.error("Invalid field name");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldLocationMatcher(location)){
                logger.error("Invalid field location");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldExtentMatcher(extent)){
                logger.error("Invalid field extent");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(fieldCode);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setLocation(location);
            fieldDTO.setExtent(extent);
            fieldDTO.setFieldImage1(base64fieldImage1);
            fieldDTO.setFieldImage2(base64fieldImage2);
            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{fieldID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable ("fieldID") String fieldId){
        if (!RegexProcess.fieldCodeMatcher(fieldId)) {
            return new SelectedFieldErrorStatus(1,"Field ID is not valid");
        }
        return fieldService.getField(fieldId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields() {
        return fieldService.getAllFields();
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateField(
            @RequestPart ("fieldCode") String fieldCode,
            @RequestPart ("fieldName") String fieldName,
            @RequestPart ("location") String location,
            @RequestPart ("extent") String extent,
            @RequestPart ("cropCode") String crop_code,
            //   @RequestPart ("staff_id") String staff_id,
            @RequestPart ("fieldImage1") MultipartFile fieldImage1,
            @RequestPart ("fieldImage2") MultipartFile fieldImage2
    ) {
        String base64fieldImage1 = "";
        String base64fieldImage2 = "";
        try {
            byte[] imageBytes1 = fieldImage1.getBytes();
            base64fieldImage1 = AppUtil.picToBase64(imageBytes1);

            byte[] imageBytes2 = fieldImage2.getBytes();
            base64fieldImage2 = AppUtil.picToBase64(imageBytes2);

            if (RegexProcess.fieldCodeMatcher(fieldCode)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(fieldCode);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setLocation(location);
            fieldDTO.setExtent(extent);
            //fieldDTO.setCropCode(crop_code);
            //fieldDTO.setStaff_id("N/A");
            fieldDTO.setFieldImage1(base64fieldImage1);
            fieldDTO.setFieldImage2(base64fieldImage2);
            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @DeleteMapping(value = "/{fieldId}")
    public ResponseEntity<Void> deleteField(@PathVariable ("fieldId") String fieldId) {
        try {
            if (!RegexProcess.fieldCodeMatcher(fieldId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            fieldService.deleteField(fieldId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}