package com.wardrobe.wardrobeapi.service;
import com.wardrobe.wardrobeapi.repository.WardrobeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wardrobe.wardrobeapi.entities.Clothing;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WardrobeServiceImpl implements WardrobeService{

    @Autowired
    WardrobeRepository wardrobeRepository;

    @Override
    @Transactional
    public Clothing add(Clothing clothing) {
        return wardrobeRepository.save(clothing);
    }

    @Override
    public Clothing getById(int id) {
        return wardrobeRepository.findOne(id);
    }

    @Override
    public List<Clothing> get() {
        return (List<Clothing>) wardrobeRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Clothing clothing) {
        wardrobeRepository.save(clothing);

    }

    @Override
    @Transactional
    public void delete(int id) {
        wardrobeRepository.delete(id);

    }
}
