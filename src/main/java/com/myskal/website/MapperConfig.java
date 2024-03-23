package com.myskal.website;

import com.myskal.website.DTO.PostDTO;
import com.myskal.website.DTO.UserDTO;
import com.myskal.website.entities.Post;
import com.myskal.website.entities.User;
import com.myskal.website.mapper.PostMapper;
import com.myskal.website.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper() {
            @Override
            public UserDTO userToUserDTO(User user) {
                return null;
            }

            @Override
            public User userDTOToUser(UserDTO userDTO) {
                return null;
            }
        };
    }


    @Bean
    public PostMapper postMapper() {
        return new PostMapper() {
            @Override
            public PostDTO postToPostDTO(Post post) {
                return null;
            }

            @Override
            public Post postDTOToPost(PostDTO postDTO) {
                return null;
            }
        };
    }
}

