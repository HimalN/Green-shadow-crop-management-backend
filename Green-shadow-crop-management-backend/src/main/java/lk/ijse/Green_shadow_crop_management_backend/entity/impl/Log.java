package lk.ijse.Green_shadow_crop_management_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.Green_shadow_crop_management_backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Log")
public class Log implements SuperEntity {
    @Id
    private String logCode;
    private String logDate;
    private String details;

    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;

    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private Field field;
    @ManyToOne
    @JoinColumn(name = "cropCode", nullable = false)
    private Crop crop;
    @ManyToOne
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;
}
