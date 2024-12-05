package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import lk.ijse.Green_shadow_crop_management_backend.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    private String vehicleCode;
    private String licensePlate;
    private String category;
    private String fuelType;
    private String status;
    private String staffId;
    private String remarks;
}
