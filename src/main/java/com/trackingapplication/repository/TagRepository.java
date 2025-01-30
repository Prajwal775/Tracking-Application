package com.trackingapplication.repository;

import com.trackingapplication.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    boolean existsByMacAddress(String macAddress);

    boolean existsBySerialNo(String serialNo);

    //all tags which are not deleted
    List<Tag> findAllByIdIsDeletedFalse();

    //find by id but only if is not deleted
    Optional<Tag> findByIdAndIsDeletedFalse(Long id);
//
}
