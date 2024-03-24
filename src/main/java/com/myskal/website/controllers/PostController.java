package com.myskal.website.controllers;

import com.myskal.website.DTO.PostDTO;
import com.myskal.website.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "Posts")
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "Get a post by ID", notes = "Retrieve details of a post based on its ID")
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @ApiOperation(value = "Get all posts", notes = "Retrieve details of all posts")
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @ApiOperation(value = "Create a new post", notes = "Create a new post with the provided details")
    @PostMapping("/posts")
    public ResponseEntity<PostDTO> createPost(@Validated @RequestBody PostDTO newPost) {
        PostDTO savedPost = postService.savePost(newPost);
        return ResponseEntity.created(URI.create("/api/posts/" + savedPost.getId())).body(savedPost);
    }

    @ApiOperation(value = "Update a post", notes = "Update an existing post with the provided details")
    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        return postService.updatePost(id, postDTO);
    }

    @ApiOperation(value = "Delete a post", notes = "Delete a post based on its ID")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
