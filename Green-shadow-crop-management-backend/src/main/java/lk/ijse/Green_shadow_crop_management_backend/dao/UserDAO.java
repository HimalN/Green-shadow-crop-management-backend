package lk.ijse.Green_shadow_crop_management_backend.dao;

import lk.ijse.Green_shadow_crop_management_backend.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
