package com.admin.webcodein.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private long userId;

}
