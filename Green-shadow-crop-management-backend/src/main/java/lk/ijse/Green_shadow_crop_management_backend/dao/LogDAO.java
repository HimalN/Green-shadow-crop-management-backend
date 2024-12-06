package lk.ijse.Green_shadow_crop_management_backend.dao;


import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<Log, String> {

}
