package lk.ijse.Green_shadow_crop_management_backend.service;

import lk.ijse.Green_shadow_crop_management_backend.dto.FieldStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO noteDTO);
    List<FieldDTO> getAllFields();
    FieldStatus getField(String noteId);
    void deleteField(String noteId);
    void updateField(String noteId, FieldDTO noteDTO);
}
