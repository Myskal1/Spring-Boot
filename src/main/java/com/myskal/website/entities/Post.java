package com.myskal.website.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;


    @ManyToOne
    private User author;

}
