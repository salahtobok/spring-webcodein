package com.admin.webcodein.domain;

import com.admin.common.data.config.DbSchema;
import com.admin.common.data.entity.AuditedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * *************************
 * **** @AFCSOFT ***** *************************
 */

/**
 * ****** Lombok Annotations *********
 */
@Data
@Entity
@Table(name = "user", schema = DbSchema.ADMINISTRATION_SCHEMA)
public class User extends AuditedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonbTransient
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @NotBlank
    @JsonbTransient
    @Column
    @Size(min = 1, max = 100)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    @Column
    @JsonbTransient
    private String lastName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

}