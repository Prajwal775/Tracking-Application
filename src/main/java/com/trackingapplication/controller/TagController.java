package com.trackingapplication.controller;

import com.trackingapplication.dto.TagDTO;
import com.trackingapplication.entity.Tag;
import com.trackingapplication.repository.TagRepository;
import com.trackingapplication.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;
    @PostMapping("/create")
    public ResponseEntity<TagDTO> createTag(@RequestBody TagDTO tagDTO)
    {
        TagDTO createdTag=tagService.createTag(tagDTO);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TagDTO>> getAll(){
     List<TagDTO> listOfAllTags=tagService.getAll();
     return ResponseEntity.ok(listOfAllTags);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> getById(@PathVariable long id){
        TagDTO tagDTO=tagService.getTagById(id);
        return ResponseEntity.ok(tagDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        return tagService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO>updateById(@PathVariable long id,@RequestBody TagDTO updatedTagDto)
    {
        TagDTO updatedTag=tagService.updateTag(id,updatedTagDto);
        return ResponseEntity.ok(updatedTag);
    }



}
