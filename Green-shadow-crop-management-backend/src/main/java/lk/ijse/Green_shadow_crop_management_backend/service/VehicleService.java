package lk.ijse.Green_shadow_crop_management_backend.service;

import lk.ijse.Green_shadow_crop_management_backend.dto.VehicleStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    VehicleStatus getVehicle(String vehicleId);
    void deleteVehicle(String vehicleId);
    void updateVehicle(String vehicleId, VehicleDTO vehicleDTO);
}
