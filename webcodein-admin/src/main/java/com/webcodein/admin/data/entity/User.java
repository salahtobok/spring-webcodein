package com.webcodein.admin.data.entity;

import com.webcodein.admin.enums.Gender;
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

    @Column(name = "uuid")
    private String uuid;

    @JsonbTransient
    @Column(name = "keycloakUUID")
    private String keycloakUUID;

    @Column(name = "username")
    protected String username;

    protected Boolean enabled;

    protected Boolean emailVerified;

    @Size(min = 1, max = 100)
    protected String firstName;

    @Size(min = 1, max = 100)
    protected String lastName;


    @Email
    @Size(min = 1, max = 100)
    @Column(name = "email", nullable = false)
    private String email;


    private String phone;

    private String mobile;


    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}