package com.myskal.website.mapper;

import com.myskal.website.DTO.UserDTO;
import com.myskal.website.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    UserDTO userToUserDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "userDTO.email")
    User userDTOToUser(UserDTO userDTO);
}
