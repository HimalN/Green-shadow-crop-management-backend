package lk.ijse.Green_shadow_crop_management_backend.customStatusCodes;


import lk.ijse.Green_shadow_crop_management_backend.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedVehicleErrorStatus implements VehicleStatus {
    private int statusCode;
    private String statusMessage;
}
