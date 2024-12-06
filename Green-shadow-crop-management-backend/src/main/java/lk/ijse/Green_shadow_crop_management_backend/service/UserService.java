package lk.ijse.Green_shadow_crop_management_backend.service;


import lk.ijse.Green_shadow_crop_management_backend.dto.UserStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserStatus getUser(String userId);

    void deleteUser(String userId);

    UserDetailsService userDetailsService();
    void updateUser(UserDTO buildUserDTO);

    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
