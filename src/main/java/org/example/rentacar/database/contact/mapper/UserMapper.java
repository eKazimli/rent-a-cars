package org.example.rentacar.database.contact.mapper;

import org.example.rentacar.database.contact.dto.UserDto;
import org.example.rentacar.database.contact.entity.users.User;

public class UserMapper {

    public static UserDto userDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setCreatedAt(user.getCreatedAt());
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        user.setCreatedAt(userDto.getCreatedAt());
        return user;
    }
}
