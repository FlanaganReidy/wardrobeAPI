package com.wardrobe.wardrobeapi.repository;

import com.wardrobe.wardrobeapi.entities.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
