package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.dao.FieldDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import lk.ijse.Green_shadow_crop_management_backend.service.FieldService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDAO fieldDAO;

    @Autowired
    private Mapping fieldMapping;

    @Override
    public void saveField(String fieldID, String fieldName, String fieldLocation, String fieldSize, String base67FieldImg01, String base67FieldImg02) {
        FieldDTO fieldDto = new FieldDTO();
        fieldDto.setFieldCode(fieldID);
        fieldDto.setFieldName(fieldName);
        fieldDto.setLocation(fieldLocation);
        fieldDto.setExtent(fieldSize);
        fieldDto.setFieldImage1(base67FieldImg01);
        fieldDto.setFieldImage2(base67FieldImg02);

        Field saved = fieldDAO.save(fieldMapping.toFieldEntity(fieldDto));
        if (saved == null) {
            throw new DataPersistException("Failed to save field");
        }
    }
}
