package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedCropErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dao.CorpDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.CropStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.CropDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Crop;
import lk.ijse.Green_shadow_crop_management_backend.exception.CropNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.CropService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceIMPL implements CropService {
    @Autowired
    private CorpDAO cropDAO;

    @Autowired
    private Mapping cropMapping;

    @Override
    public void saveCrop(CropDTO cropDTO) {
        Crop saveField = cropDAO.save(cropMapping.toCropEntity(cropDTO));
        if(saveField == null){
            throw new RuntimeException("Crop not saved");
        }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return cropMapping.asCropDTOList(cropDAO.findAll());
    }

    @Override
    public CropStatus getCrop(String cropId) {
        if(cropDAO.existsById(cropId)){
            var selectedCrop = cropDAO.getReferenceById(cropId);
            return cropMapping.toCropDTO(selectedCrop);
        }else {
            return new SelectedCropErrorStatus(404,"Selected crop not found");
        }
    }

    @Override
    public void deleteCrop(String cropId) {
        Optional<Crop> byCropId = cropDAO.findById(cropId);
        if (!byCropId.isPresent()) {
            throw new CropNotFoundException("Crop not found");
        }else {
            cropDAO.deleteById(cropId);
        }
    }

    @Override
    public void updateCrop(String cropId, CropDTO cropDTO) {

    }
}
