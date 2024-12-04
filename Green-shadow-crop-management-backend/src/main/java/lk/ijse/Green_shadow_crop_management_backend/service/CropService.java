package lk.ijse.Green_shadow_crop_management_backend.service;

import lk.ijse.Green_shadow_crop_management_backend.dto.CropStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropStatus getCrop(String cropId);
    void deleteCrop(String cropId);
    void updateCrop(String cropId, CropDTO cropDTO);
}
