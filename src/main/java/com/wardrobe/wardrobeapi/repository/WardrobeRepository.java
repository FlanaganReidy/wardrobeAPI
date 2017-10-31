package com.wardrobe.wardrobeapi.repository;

import com.wardrobe.wardrobeapi.entities.Clothing;
import org.springframework.data.repository.CrudRepository;

public interface WardrobeRepository extends CrudRepository<Clothing, Integer> {

}
