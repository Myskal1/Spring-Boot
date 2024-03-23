package com.myskal.website.services;

import com.myskal.website.DTO.PostDTO;
import com.myskal.website.entities.Post;
import com.myskal.website.mapper.PostMapper;
import com.myskal.website.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void testGetPostById() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
        post.setContent("This is a test post content.");
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        PostDTO postDTO = postService.getPostById(1L);

        assertThat(postDTO).isNotNull();
        assertThat(postDTO.getId()).isEqualTo(1L);
        assertThat(postDTO.getTitle()).isEqualTo("Test Post");
        assertThat(postDTO.getContent()).isEqualTo("This is a test post content.");
    }

}

