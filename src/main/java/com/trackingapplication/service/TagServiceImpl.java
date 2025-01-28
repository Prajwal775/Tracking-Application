package com.trackingapplication.service;

import com.trackingapplication.entity.Tag;
import com.trackingapplication.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag updateTag(Long id, Tag updatedTag) {
        Tag existingTag=tagRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        //updating the details;
//        existingTag.setSerial_no(updatedTag.getSerial_no());
        existingTag.setMac_address(updatedTag.getMac_address());
        existingTag.setTagtype(updatedTag.getTagtype());

        return tagRepository.save(existingTag);
    }
}
