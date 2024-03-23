package com.myskal.website.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.myskal.website.entities.User;
import com.myskal.website.entities.Post;
import com.myskal.website.repositories.UserRepository;
import com.myskal.website.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class InitData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public InitData(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {
        Post post1 = new Post();
        post1.setTitle("First post");
        post1.setContent("Spring");
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setTitle("Second Post");
        post2.setContent("Spring boot");
        postRepository.save(post2);


    }
}

