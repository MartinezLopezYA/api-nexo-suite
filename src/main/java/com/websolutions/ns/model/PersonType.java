package com.websolutions.ns.model;

import com.websolutions.ns.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "person_types")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonType extends BaseEntity {

    @Column(name = "person_type_name", unique = true)
    private String personTypeName;

    @Column(name = "person_type_code", unique = true)
    private String personTypeCode;

}
