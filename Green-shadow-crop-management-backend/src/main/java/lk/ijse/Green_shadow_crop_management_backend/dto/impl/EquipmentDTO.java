package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.Green_shadow_crop_management_backend.dto.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Equipment")
public class EquipmentDTO implements EquipmentStatus {
    @Id
    private String equipmentId;
    private String equipmentName;
    private String equipmentType;
    private String equipmentStatus;
    private String staffId;
    private String fieldCode;
}
