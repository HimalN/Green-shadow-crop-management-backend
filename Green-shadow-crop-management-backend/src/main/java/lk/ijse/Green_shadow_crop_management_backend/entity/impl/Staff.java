package lk.ijse.Green_shadow_crop_management_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.Green_shadow_crop_management_backend.entity.Gender;
import lk.ijse.Green_shadow_crop_management_backend.entity.Role;
import lk.ijse.Green_shadow_crop_management_backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Staff")
public class Staff implements SuperEntity {
    @Id
    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String joinedDate;
    private String dob;
    @Column(name = "Building no or name")
    private String addressLine1;
    @Column(name = "Street no or name")
    private String addressLine2;
    @Column(name = "City")
    private String addressLine3;
    @Column(name = "State")
    private String addressLine4;
    @Column(name = "Postal code")
    private String addressLine5;
    private String contactNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private Field field;
    @OneToMany(mappedBy = "staff")
    private List<Vehicle> vehicles;
    @OneToMany(mappedBy = "staff")
    private List<Equipment> equipments;
}
