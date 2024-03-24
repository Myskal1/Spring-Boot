package com.myskal.website.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.apache.catalina.authenticator.SavedRequest;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String username;

    private Set<PostDTO> posts;

}
