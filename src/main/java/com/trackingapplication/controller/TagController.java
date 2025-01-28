package com.trackingapplication.controller;

import com.trackingapplication.entity.Tag;
import com.trackingapplication.repository.TagRepository;
import com.trackingapplication.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagRepository tagRepository;
    private final TagService tagService;

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

//    @GetMapping("/{id}")



}
