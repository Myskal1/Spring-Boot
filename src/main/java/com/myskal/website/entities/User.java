package com.myskal.website.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@AllArgsConstructor
@Builder
@Data

public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    @OneToMany
    private List<Post> posts;


    public User() {

    }
}
