package com.wardrobe.wardrobeapi.repository;

import com.wardrobe.wardrobeapi.models.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardrobeRepository extends JpaRepository<Clothing, Integer>{

}
