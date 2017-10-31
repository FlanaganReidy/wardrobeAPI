package com.wardrobe.wardrobeapi.service;

import com.wardrobe.wardrobeapi.entities.Photo;
import com.wardrobe.wardrobeapi.repository.PhotoRepository;

import java.util.List;

public interface PhotoService {
        Photo add(Photo photo);
        Photo getById(int id);
        List<Photo> get();
        void update(Photo clothing);
        void delete(int id);

}
