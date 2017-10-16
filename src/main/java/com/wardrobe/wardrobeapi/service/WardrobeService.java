package com.wardrobe.wardrobeapi.service;

import com.wardrobe.wardrobeapi.models.Clothing;

import java.util.List;

public interface WardrobeService {
    Clothing add(Clothing clothing);
    Clothing getById(int id);
    List<Clothing> get();
    void update(Clothing clothing);
    void delete(int id);
}
