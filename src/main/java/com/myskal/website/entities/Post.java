package com.myskal.website.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20, message = "Title length not to be greater than 20")
    @Column(length = 20)
    private String title;
    private String content;


    @ManyToOne
    private User user;

    public Post() {

    }
}
