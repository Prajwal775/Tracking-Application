package com.trackingapplication.service;

import com.trackingapplication.entity.Tag;

import java.util.List;

public interface TagService {

    Tag createTag(Tag tag);
    Tag getTagById(Long id);
    List<Tag> getAll();
    void deleteById(Long id);
    Tag updateTag(Long id,Tag tag);

}
