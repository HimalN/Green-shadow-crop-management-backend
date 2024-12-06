package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import lk.ijse.Green_shadow_crop_management_backend.dto.UserStatus;
import lk.ijse.Green_shadow_crop_management_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    private Role role;
    private String email;
    private String password;
}
