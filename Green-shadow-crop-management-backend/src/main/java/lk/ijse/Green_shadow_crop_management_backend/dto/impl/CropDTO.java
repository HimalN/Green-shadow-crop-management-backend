package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import lk.ijse.Green_shadow_crop_management_backend.dto.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
    private String code;
    private String commonName;
    private String scientificName;
    private String image;
    private String category;
    private String season;
    private String fieldCode;
}
