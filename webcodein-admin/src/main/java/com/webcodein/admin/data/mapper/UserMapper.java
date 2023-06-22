package com.webcodein.admin.data.mapper;

import com.webcodein.admin.data.entity.User;
import com.webcodein.admin.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public void updateGivenDtoByEntityData(User entity, UserDto dto) {
        dto.setUuid(entity.getUuid());
        dto.setKeycloakUUID(entity.getKeycloakUUID());
        dto.setUsername(entity.getUsername());
        dto.setEnabled(entity.getEnabled());
        dto.setEmailVerified(entity.getEmailVerified());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setMobile(entity.getMobile());
        dto.setDob(entity.getDob());
        dto.setGender(entity.getGender());
    }


    public void updateGivenEntityDataByDto(User entity, UserDto dto) {
        entity.setUuid(dto.getUuid());
        entity.setKeycloakUUID(dto.getKeycloakUUID());
        entity.setUsername(dto.getUsername());
        entity.setEnabled(dto.getEnabled());
        entity.setEmailVerified(dto.getEmailVerified());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setMobile(dto.getMobile());
        entity.setDob(dto.getDob());
        entity.setGender(dto.getGender());
    }
}