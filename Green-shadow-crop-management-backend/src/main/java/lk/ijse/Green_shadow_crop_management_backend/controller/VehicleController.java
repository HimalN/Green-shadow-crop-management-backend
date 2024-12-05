package lk.ijse.Green_shadow_crop_management_backend.controller;

import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedVehicleErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.VehicleStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.VehicleDTO;
import lk.ijse.Green_shadow_crop_management_backend.service.VehicleService;
import lk.ijse.Green_shadow_crop_management_backend.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {
    static Logger logger =  LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(
            @RequestPart("vehicleCode") String vehicleCode,
            @RequestPart("licensePlate") String licensePlate,
            @RequestPart("category") String category,
            @RequestPart("fuelType") String fuelType,
            @RequestPart("status") String status,
            @RequestPart("staff") String staff,
            @RequestPart("remarks") String remarks
    ) {
        try {
            if (!RegexProcess.vehicleIdMatcher(vehicleCode)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setVehicleCode(vehicleCode);
            vehicleDTO.setLicensePlate(licensePlate);
            vehicleDTO.setCategory(category);
            vehicleDTO.setFuelType(fuelType);
            vehicleDTO.setStatus(status);
            vehicleDTO.setStaffId(staff);
            vehicleDTO.setRemarks(remarks);
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{vehicleID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleStatus getSelectedVehicle(@PathVariable ("vehicleID") String vehicleId){
        if (!RegexProcess.vehicleIdMatcher(vehicleId)) {
            return new SelectedVehicleErrorStatus(1,"Vehicle ID is not valid");
        }
        return vehicleService.getVehicle(vehicleId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

}
