package com.admin.webcodein.data.entity;

import com.admin.common.data.entity.AuditedEntity;
import com.admin.common.data.config.DbSchema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

@Entity
@Table(name = "admin_user", schema = DbSchema.ADMINISTRATION_SCHEMA)
public class User extends AuditedEntity implements Serializable {
    private static Log log = LogFactory.getLog(User.class);


    @Column(name = "firstName", unique = true)
    private String firstName;

    @Column(name = "lastName", unique = true)
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

}