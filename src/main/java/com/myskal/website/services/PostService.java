package com.myskal.website.services;

import com.myskal.website.DTO.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDTO getPostById(Long id);
    PostDTO savePost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostDTO createPost(PostDTO postDTO);
    PostDTO updatePost(Long id, PostDTO postDTO);
    void deletePost(Long id);
}
