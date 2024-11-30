package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import jakarta.persistence.Column;
import lk.ijse.Green_shadow_crop_management_backend.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
        private String fieldCode;
        private String fieldName;
        private String location;
        private String extent;
        @Column(columnDefinition = "LONGTEXT")
        private String fieldImage1;
        @Column(columnDefinition = "LONGTEXT")
        private String fieldImage2;

}
