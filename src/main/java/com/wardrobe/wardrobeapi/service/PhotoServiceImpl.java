package com.wardrobe.wardrobeapi.service;

import com.wardrobe.wardrobeapi.entities.Photo;
import com.wardrobe.wardrobeapi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    @Override
    public Photo add(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo getById(int id) {
        return photoRepository.findOne(id);
    }

    @Override
    public List<Photo> get() {
        return (List<Photo>) photoRepository.findAll();
    }

    @Override
    public void update(Photo photo) {
        photoRepository.save(photo);

    }

    @Override
    public void delete(int id) {
        photoRepository.delete(id);

    }
}
