package com.webcodein.admin.data.entity;

import com.webcodein.common.data.config.DbSchema;
import com.webcodein.common.data.entity.BasicEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.*;

@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
@Entity
@Table(name = "admin_user", schema = DbSchema.ADMINISTRATION_SCHEMA)
public class User extends BasicEntity implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    private Long id;

    @NotNull
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @JsonbTransient
    @Column
    private String keycloakUUID;

    @NotNull
    @NotBlank
    @Column(name = "username")
    protected String username;

    protected Boolean enabled;

    protected Boolean emailVerified;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    protected String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    protected String lastName;


    @Email
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email", nullable = false)
    private String email;


    private String phone;

    private String mobile;

}