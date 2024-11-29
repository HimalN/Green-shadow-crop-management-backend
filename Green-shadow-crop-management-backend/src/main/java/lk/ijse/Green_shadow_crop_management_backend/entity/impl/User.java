package lk.ijse.Green_shadow_crop_management_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.entity.Role;
import lk.ijse.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User implements SuperEntity {
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
