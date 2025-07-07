package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"business_uuid", "role_name"})
})
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Column(name = "role_desc", length = 200)
    private String roleDesc;

    @Column(name = "role_status")
    private Boolean roleStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_uuid", nullable = false)
    private Business business;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_uuid"),
            inverseJoinColumns = @JoinColumn(name = "permission_uuid")
    )
    private Set<Permission> permissions = new HashSet<>();

}
