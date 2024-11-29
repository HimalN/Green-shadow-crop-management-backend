
package lk.ijse.Green_shadow_crop_management_backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class Field implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String location;
    private String extent;
    @OneToMany(mappedBy="field")
    private List<Crop> crops;
    @OneToMany(mappedBy="field")
    private List<Staff> staff;
    @OneToMany(mappedBy="field")
    private List<Equipment> equipment;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;
}
