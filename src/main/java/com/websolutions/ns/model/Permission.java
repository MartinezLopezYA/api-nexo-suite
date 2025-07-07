package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "permissions")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission extends BaseEntity {

    @Column(name = "permission_name", nullable = false, unique = true, length = 100)
    private String permissionName;

    @Column(name = "permission_code", nullable = false, unique = true, length = 50)
    private String permissionCode;

    @Column(name = "permission_desc", length = 200)
    private String permissionDesc;

    @Column(name = "permission_status")
    private Boolean permissionStatus;

}
