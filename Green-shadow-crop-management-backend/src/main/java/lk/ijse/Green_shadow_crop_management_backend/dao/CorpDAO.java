package lk.ijse.Green_shadow_crop_management_backend.dao;

import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Crop;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpDAO extends JpaRepository<Crop, String> {
}
