package com.trackingapplication.service;

import com.trackingapplication.dto.TagDTO;
import com.trackingapplication.entity.Tag;
import com.trackingapplication.exception.CustomException;
import com.trackingapplication.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService{


    @Autowired
    private ModelMapper modelMapper;


    //validation check
    //dto to entity
    //db save-dto to entity
    //enity to dto then return
    //converstion through mapper

    @Autowired
    private TagRepository tagRepository;

    @Override
    public TagDTO createTag(TagDTO tagDTO) {
        if(tagRepository.existsByMacAddressOrSerialNo(tagDTO.getMac_address(), tagDTO.getSerial_no())){
            throw new CustomException("Device with this Mac Address or Serial Numnber Already exists.");
        }

        //convert dto to entity
        Tag tag=modelMapper.map(tagDTO,Tag.class);
        //saving the entity
           Tag savedtag=tagRepository.save(tag);

           return modelMapper.map(savedtag, TagDTO.class);

    }

    @Override
    public TagDTO getTagById(Long id) {

         Tag tag=tagRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with id: " + id));
    return modelMapper.map(tag, TagDTO.class);
    }
//
    @Override
    public List<TagDTO> getAll() {
        return tagRepository.findAll().stream()
                .map(tag -> modelMapper.map(tag, TagDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        Tag tag=tagRepository.findById(id).orElseThrow(()-> new CustomException("User not found with id :" + id));
        tag.setIsDeleted(true);
        tagRepository.save(tag);
        return ResponseEntity.ok("Tag with ID " + id + " has been soft deleted.");
    }

    @Override
    public TagDTO updateTag(Long id, TagDTO updatedTagDto) {
        Tag existingTag=tagRepository.findById(id).orElseThrow(() -> new CustomException("User not found with id: " + id));

//      Updating the details;
//        existingTag.setSerial_no(updatedTagDto.getSerial_no());
//        existingTag.setMac_address(updatedTagDto.getMac_address());
//        existingTag.setTagtype(updatedTagDto.getTagtype());

        //updating by using model mapper
//map fields from dto to the exsting entity
        modelMapper.map(updatedTagDto,existingTag);

        // Save the updated entity
        Tag savedTag = tagRepository.save(existingTag);

        // Convert the saved entity to DTO using ModelMapper
        return modelMapper.map(savedTag, TagDTO.class);
    }


//
//
////    //use mapper
////    private TagDTO convertEntityToDto(Tag tag){
////        TagDTO tagDTO=new TagDTO();
////        tagDTO.setMac_address(tag.getMac_address());
////        tagDTO.setSerial_no(tag.getSerial_no());
////        tagDTO.setTagtype(tag.getTagtype());
////
////        return tagDTO;
////    }
//
//
    //use ModelMapper
    private TagDTO convertEntityToDto(Tag tag){
        TagDTO tagDTO=new TagDTO();
        tagDTO=modelMapper.map(tag, TagDTO.class);
        return tagDTO;
    }
}