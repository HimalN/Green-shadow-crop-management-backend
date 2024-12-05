package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import lk.ijse.Green_shadow_crop_management_backend.dto.StaffStatus;
import lk.ijse.Green_shadow_crop_management_backend.entity.Gender;
import lk.ijse.Green_shadow_crop_management_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private String joinedDate;
    private String dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private Role role;
    private String fieldCode;
}
