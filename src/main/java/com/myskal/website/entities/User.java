package com.myskal.website.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import lombok.*;


import java.util.List;
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "varchar(7)")
    private Long id;
    @Column(length = 12)
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();


    public User() {

    }
}
