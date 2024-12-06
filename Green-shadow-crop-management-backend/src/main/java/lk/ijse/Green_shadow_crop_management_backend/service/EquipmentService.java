package lk.ijse.Green_shadow_crop_management_backend.service;

import lk.ijse.Green_shadow_crop_management_backend.dto.EquipmentStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO> getAllEquipments();
    EquipmentStatus getEquipment(String equipmentId);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO);
}
