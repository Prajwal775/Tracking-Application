package com.trackingapplication.controller;

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
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag)
    {
        Tag createdTag=tagService.createTag(tag);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
    }

//    @GetMapping("/getAll")
//    public List<Tag> getAll(){
//        return tagService.getAll();
//    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tag>> getAll(){
     List<Tag> listOfAllTags=tagService.getAll();
     return ResponseEntity.ok(listOfAllTags);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tag> getById(@PathVariable long id){
        Tag tag=tagService.getTagById(id);
        return ResponseEntity.ok(tag);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        tagService.deleteById(id);
        return ResponseEntity.ok("deleted id with"+ id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag>updateById(@PathVariable long id,@RequestBody Tag updatedTag)
    {
        Tag utag=tagService.updateTag(id,updatedTag);
        return ResponseEntity.ok(utag);
    }


}
