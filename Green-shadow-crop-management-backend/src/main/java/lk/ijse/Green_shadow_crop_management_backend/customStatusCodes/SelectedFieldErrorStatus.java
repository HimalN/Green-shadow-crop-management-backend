package lk.ijse.Green_shadow_crop_management_backend.customStatusCodes;


import lk.ijse.Green_shadow_crop_management_backend.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedFieldErrorStatus implements FieldStatus {
    private int statusCode;
    private String statusMessage;
}
