package com.trackingapplication.service;

import com.trackingapplication.dto.TagDTO;
import com.trackingapplication.entity.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TagService {

    TagDTO createTag(TagDTO tagDTO);
    TagDTO getTagById(Long id);
    List<TagDTO> getAll();
    ResponseEntity<String> deleteById(Long id);
    TagDTO updateTag(Long id,TagDTO tagDTO);

}
