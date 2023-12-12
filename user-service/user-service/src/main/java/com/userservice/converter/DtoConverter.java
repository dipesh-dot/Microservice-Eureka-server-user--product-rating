package com.userservice.converter;

import com.userservice.dto.UserDto;
import com.userservice.entity.User;

public class DtoConverter {
    public static UserDto convert(User entity){
        if(entity == null)
            return null;

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());

        return dto;
    }
}
