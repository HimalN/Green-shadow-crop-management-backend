package lk.ijse.Green_shadow_crop_management_backend.util;


import lk.ijse.Green_shadow_crop_management_backend.dto.impl.CropDTO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.StaffDTO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.VehicleDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Crop;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Staff;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Vehicle;
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

    public Staff toStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, Staff.class);
    }
    public StaffDTO toStaffDTO(Staff staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public List<StaffDTO> asStaffDTOList(List<Staff> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>() {}.getType());
    }

    public Vehicle toVehicleEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }
    public VehicleDTO toVehicleDTO(Vehicle vehicleEntity) {
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public List<VehicleDTO> asVehicleDTOList(List<Vehicle> vehicleEntities) {
        return modelMapper.map(vehicleEntities, new TypeToken<List<VehicleDTO>>() {}.getType());
    }
}
