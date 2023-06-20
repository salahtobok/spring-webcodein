package com.webcodein.admin.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.webcodein.common.data.config.DbSchema;
import com.webcodein.common.data.entity.AuditedEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.keycloak.json.StringListMapDeserializer;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.FederatedIdentityRepresentation;
import org.keycloak.representations.idm.SocialLinkRepresentation;
import org.keycloak.representations.idm.UserConsentRepresentation;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.*;

@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
@Entity
@Table(name = "admin_user", schema = DbSchema.ADMINISTRATION_SCHEMA)
public class User extends AuditedEntity implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    private Long id;

    @NotNull
    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @JsonbTransient
    @Column(unique = true)
    private String keycloakUUID;

    @NotNull
    @NotBlank
    @Column(name = "username", unique = true)
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
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Transient
    @JsonbTransient
    protected List<String> realmRoles;

    @Transient
    @JsonbTransient
    protected Map<String, List<String>> clientRoles;

    @Transient
    @JsonbTransient
    protected List<String> groups;

    private String phone;

    private String mobile;

}