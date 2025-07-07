package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cities")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends BaseEntity {

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @Column(name = "city_code", nullable = false)
    private String cityCode;

    @Column(name = "city_status")
    private Boolean cityStatus;

    @ManyToOne
    @JoinColumn(name = "department_uuid", nullable = false)
    private Department department;

}
