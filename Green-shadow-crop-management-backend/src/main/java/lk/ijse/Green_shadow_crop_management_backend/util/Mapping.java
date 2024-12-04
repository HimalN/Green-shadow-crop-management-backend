package lk.ijse.Green_shadow_crop_management_backend.util;


import lk.ijse.Green_shadow_crop_management_backend.dto.impl.CropDTO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Crop;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    /*for field mapping*/
    public Field toFieldEntity(FieldDTO fieldDto) {return modelMapper.map(fieldDto, Field.class);}
    public FieldDTO toFieldDTO(Field fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public List<FieldDTO> asFieldDTOList(List<Field> fieldEntities) {return modelMapper.map(fieldEntities, new TypeToken<List<FieldDTO>>() {}.getType());}

    public Crop toCropEntity(CropDTO cropDTO) {
        return modelMapper.map(cropDTO, Crop.class);
    }
    public CropDTO toCropDTO(Crop cropEntity) {
        return modelMapper.map(cropEntity, CropDTO.class);
    }
    public List<CropDTO> asCropDTOList(List<Crop> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDTO>>() {}.getType());
    }
}
