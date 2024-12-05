package lk.ijse.Green_shadow_crop_management_backend.dao;

import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<Vehicle, String> {
}
