package lk.ijse.Green_shadow_crop_management_backend.dto.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.Green_shadow_crop_management_backend.dto.LogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Log")
public class LogDTO implements LogStatus {
    @Id
    private String logCode;
    private String logDate;
    private String details;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;
    private String fieldCode;
    private String cropCode;
    private String staffId;
}
