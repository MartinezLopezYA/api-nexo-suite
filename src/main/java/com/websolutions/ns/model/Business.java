package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import com.websolutions.ns.util.BusinessType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "businesses")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Business extends BaseEntity {

    @Column(name = "business_identification", nullable = false, unique = true, length = 12)
    private String businessIdentification;

    @Column(name = "business_dv", nullable = false, length = 1)
    private String businessDv;

    @Column(name = "business_name", nullable = false, unique = true, length = 80)
    private String businessName;

    @Column(name = "business_desc", length = 300)
    private String businessDesc;

    @Column(name = "business_email", length = 100)
    private String businessEmail;

    @Column(name = "business_phone", length = 20)
    private String businessPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_type", nullable = false, length = 30)
    private BusinessType businessType;

    @Column(name = "business_status")
    private Boolean businessStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_type_uuid", nullable = false)
    private PersonType personType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identification_type_uuid", nullable = false)
    private IdentificationType identificationType;

}
