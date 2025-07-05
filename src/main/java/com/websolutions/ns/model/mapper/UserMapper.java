package com.websolutions.ns.model.mapper;

import com.websolutions.ns.dto.UserRequestDTO;
import com.websolutions.ns.dto.UserResponseDTO;
import com.websolutions.ns.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUserEmail(dto.getUserEmail());
        user.setUserName(dto.getUserName());
        user.setUserPhone(dto.getUserPhone());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUuid(user.getUuid());
        dto.setUserEmail(user.getUserEmail());
        dto.setUserName(user.getUserName());
        dto.setUserPhone(user.getUserPhone());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

}