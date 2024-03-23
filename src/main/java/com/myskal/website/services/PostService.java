package com.myskal.website.services;

import com.myskal.website.DTO.PostDTO;
import java.util.List;

public interface PostService {

    PostDTO getPostById(Long id);

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    void deletePost(Long id);
}

