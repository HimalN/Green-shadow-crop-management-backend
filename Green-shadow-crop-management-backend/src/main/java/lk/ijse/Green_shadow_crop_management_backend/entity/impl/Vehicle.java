package lk.ijse.Green_shadow_crop_management_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Vehicle")
public class Vehicle implements SuperEntity {
    @Id
    private String vehicleCode;
    private String licensePlate;
    private String category;
    private String fuelType;
    private String status;
    @ManyToOne
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;
    private String remarks;
}
