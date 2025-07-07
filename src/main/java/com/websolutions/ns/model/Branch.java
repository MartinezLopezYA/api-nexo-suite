package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "branches")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch extends BaseEntity {

    @Column(name = "branch_name", nullable = false, unique = true, length = 100)
    private String branchName;

    @Column(name = "branch_address", nullable = false, length = 200)
    private String branchAddress;

    @Column(name = "latitude", precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "branch_phone", length = 20)
    private String branchPhone;

    @Column(name = "branch_email", length = 100)
    private String branchEmail;

    @Column(name = "branch_status")
    private Boolean branchStatus = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_uuid", nullable = false)
    private Business business;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_uuid", nullable = false)
    private City city;

}
