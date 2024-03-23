package com.myskal.website.mapper;

import com.myskal.website.DTO.PostDTO;
import com.myskal.website.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mappings({
            @Mapping(target = "id", source = "post.id"),
            @Mapping(target = "title", source = "post.title"),
            @Mapping(target = "content", source = "post.content"),

    })
    PostDTO postToPostDTO(Post post);

    @Mappings({
            @Mapping(target = "id", source = "postDTO.id"),
            @Mapping(target = "title", source = "postDTO.title"),
            @Mapping(target = "content", source = "postDTO.content"),
    })
    Post postDTOToPost(PostDTO postDTO);
}
