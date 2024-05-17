package com.myskal.website.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    private boolean verified;

    @Builder.Default
    private String role = "USER";


}
