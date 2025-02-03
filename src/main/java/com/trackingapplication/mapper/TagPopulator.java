package com.trackingapplication.mapper;

import com.trackingapplication.dto.TagDTO;
import com.trackingapplication.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagPopulator {


    TagPopulator INSTANCE = Mappers.getMapper(TagPopulator.class);


    //if i don't want to set id because a dto shall not overwrite the id when its auto generated.
    //also remember only use this whole when converting an dto to entity
    // Ignore id when converting DTO to Entity (avoiding manual id setting)

    @Mapping(target = "id",ignore = true)
    Tag populateTag(TagDTO tagDTO);

    // Do NOT ignore id when converting Entity to DTO (so id is returned in the response)

    TagDTO populateTagDto(Tag tag);
}
