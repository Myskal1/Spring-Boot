package com.myskal.website.mapper;

import com.myskal.website.DTO.UserDTO;
import com.myskal.website.entities.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void testUserToUserDTO() {
        
        User user = new User();
        user.setId(1L);
        user.setUsername("testUser");


        UserDTO userDTO = userMapper.userToUserDTO(user);


        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getId()).isEqualTo(user.getId());
        assertThat(userDTO.getUsername()).isEqualTo(user.getUsername());
    }

}
