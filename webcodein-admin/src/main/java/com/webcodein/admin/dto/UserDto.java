package com.webcodein.admin.dto;

import com.webcodein.admin.enums.Gender;
import com.webcodein.common.data.entity.BasicEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class UserDto extends BasicEntity implements Serializable, Cloneable {

    private Long id;

    private String uuid;

    private String keycloakUUID;

    protected String username;

    protected Boolean enabled;

    protected Boolean emailVerified;

    protected String firstName;

    protected String lastName;

    private String email;

    private String phone;

    private String mobile;

    private Date dob;

    private Gender gender;


}