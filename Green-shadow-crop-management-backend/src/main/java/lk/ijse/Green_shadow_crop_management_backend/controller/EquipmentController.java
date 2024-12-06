package lk.ijse.Green_shadow_crop_management_backend.controller;


import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedEquipmentErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.EquipmentStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.EquipmentDTO;
import lk.ijse.Green_shadow_crop_management_backend.exception.EquipmentNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.EquipmentService;
import lk.ijse.Green_shadow_crop_management_backend.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipments")
public class EquipmentController {
    static Logger logger =  LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(
            @RequestPart("equipmentId") String equipmentId,
            @RequestPart ("equipmentName") String equipmentName,
            @RequestPart ("equipmentType") String equipmentType,
            @RequestPart ("equipmentStatus") String equipmentStatus,
            @RequestPart ("staffId") String staffId,
            @RequestPart ("fieldCode") String fieldCode
    ){
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setEquipmentId(equipmentId);
            equipmentDTO.setEquipmentName(equipmentName);
            equipmentDTO.setEquipmentType(equipmentType);
            equipmentDTO.setEquipmentStatus(equipmentStatus);
            equipmentDTO.setStaffId(staffId);
            equipmentDTO.setFieldCode(fieldCode);

            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{equipmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquipment(@PathVariable ("equipmentId") String equipmentId) {
        if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
            return new SelectedEquipmentErrorStatus(1, "Equipment ID is not valid");
        }
        return equipmentService.getEquipment(equipmentId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipmentDTO> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable ("equipmentId") String equipmentId){
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            equipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EquipmentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEquipment(
            @RequestPart ("equipmentId") String equipmentId,
            @RequestPart ("equipmentName") String equipmentName,
            @RequestPart ("equipmentType") String equipmentType,
            @RequestPart ("equipmentStatus") String equipmentStatus,
            @RequestPart ("staffId") String staffId,
            @RequestPart ("fieldCode") String fieldCode
    ) {
        try {
            if (!RegexProcess.equipmentIdMatcher(equipmentId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setEquipmentId(equipmentId);
            equipmentDTO.setEquipmentName(equipmentName);
            equipmentDTO.setEquipmentType(equipmentType);
            equipmentDTO.setEquipmentStatus(equipmentStatus);
            equipmentDTO.setStaffId(staffId);
            equipmentDTO.setFieldCode(fieldCode);

            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
