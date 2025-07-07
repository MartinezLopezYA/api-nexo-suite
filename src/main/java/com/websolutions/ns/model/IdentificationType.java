package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "identification_types")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IdentificationType extends BaseEntity {

    @Column(name = "identification_type_name", nullable = false, unique = true)
    private String identificationTypeName;

    @Column(name = "identification_type_abbrev", nullable = false, unique = true)
    private String identificationTypeAbbrev;

    @Column(name = "identification_type_code", nullable = false, unique = true)
    private String identificationTypeCode;

    @Column(name = "identification_type_status", nullable = false, unique = true)
    private Boolean identificationTypeStatus;

}
