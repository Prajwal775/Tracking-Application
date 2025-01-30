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
        if(tagRepository.existsByMacAddress(tag.getMac_address())
            || tagRepository.existsBySerialNo(tag.getSerial_no())){
            throw new RuntimeException("Device with this Mac Address or Serial Numnber Already exists.");
        }
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAllByIdIsDeletedFalse();
    }

    @Override
    public String deleteById(Long id) {
        Tag tag=tagRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with id :" + id));
        tag.setIsDeleted(true);
        tagRepository.save(tag);
        return "tag with id"+id+"has been soft deleted";
    }

    @Override
    public Tag updateTag(Long id, Tag updatedTag) {
        Tag existingTag=tagRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

//      Updating the details;
        existingTag.setSerial_no(updatedTag.getSerial_no());
        existingTag.setMac_address(updatedTag.getMac_address());
        existingTag.setTagtype(updatedTag.getTagtype());

        return null;
    }
}
