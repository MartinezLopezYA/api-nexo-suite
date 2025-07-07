package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true, length = 100)
    private String countryName;

    @Column(name = "country_iso_code", nullable = false, unique = true, length = 3)
    private String countryIsoCode;

    @Column(name = "country_numeric_code", nullable = false, unique = true, length = 4)
    private String countryNumericCode;

    @Column(name = "country_status")
    private Boolean countryStatus;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();


}
