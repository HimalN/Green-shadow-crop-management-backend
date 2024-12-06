package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedEquipmentErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dao.EquipmentDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.EquipmentStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.EquipmentDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Equipment;
import lk.ijse.Green_shadow_crop_management_backend.exception.EquipmentNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.EquipmentService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EquipmentServiceIMPL implements EquipmentService {

    @Autowired
    private EquipmentDAO equipmentDAO;

    @Autowired
    private Mapping equipmentMapping;

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        Equipment saveField = equipmentDAO.save(equipmentMapping.toEquipmentEntity(equipmentDTO));
        if(saveField == null){
            throw new RuntimeException("Equipment not saved");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipments() {
        return equipmentMapping.asEquipmentDTOList(equipmentDAO.findAll());
    }

    @Override
    public EquipmentStatus getEquipment(String equipmentId) {
        if(equipmentDAO.existsById(equipmentId)){
            var selectedEquipment = equipmentDAO.getReferenceById(equipmentId);
            return equipmentMapping.toEquipmentDTO(selectedEquipment);
        }else {
            return new SelectedEquipmentErrorStatus(404,"Selected equipment not found");
        }
    }

    @Override
    public void deleteEquipment(String equipmentId) {
        Optional<Equipment> byEquipmentId = equipmentDAO.findById(equipmentId);
        if (!byEquipmentId.isPresent()) {
            throw new EquipmentNotFoundException("Equipment not found");
        }else {
            equipmentDAO.deleteById(equipmentId);
        }
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO) {

    }
}
