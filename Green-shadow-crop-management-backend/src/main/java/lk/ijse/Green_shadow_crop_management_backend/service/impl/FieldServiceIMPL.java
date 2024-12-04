package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.dao.FieldDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.FieldStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import lk.ijse.Green_shadow_crop_management_backend.service.FieldService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDAO fieldDAO;

    @Autowired
    private Mapping fieldMapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        Field savedField = fieldDAO.save(fieldMapping.toFieldEntity(fieldDTO));
        if(savedField == null){
            throw new DataPersistException("Field not saved");
        }
    }

    @Override
    public List<FieldDTO> getAllFields() {
        return List.of();
    }

    @Override
    public FieldStatus getField(String noteId) {
        return null;
    }

    @Override
    public void deleteField(String noteId) {

    }

    @Override
    public void updateField(String noteId, FieldDTO noteDTO) {

    }
}
