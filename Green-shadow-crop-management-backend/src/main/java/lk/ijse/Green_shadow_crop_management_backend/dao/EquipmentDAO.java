package lk.ijse.Green_shadow_crop_management_backend.dao;

import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Equipment;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDAO extends JpaRepository<Equipment, String> {
}
