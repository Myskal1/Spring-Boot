package com.myskal.website.services;

import com.myskal.website.DTO.PostDTO;
import com.myskal.website.entities.Post;
import com.myskal.website.mapper.PostMapper;
import com.myskal.website.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return postMapper.postToPostDTO(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(postMapper::postToPostDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = postMapper.postDTOToPost(postDTO);
        post = postRepository.save(post);
        return postMapper.postToPostDTO(post);
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setTitle(postDTO.getTitle());
        existingPost.setContent(postDTO.getContent());
        existingPost = postRepository.save(existingPost);
        return postMapper.postToPostDTO(existingPost);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
