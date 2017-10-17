package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.repository.WardrobeRepository;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import com.wardrobe.wardrobeapi.service.WardrobeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WardrobeController {

    @Autowired
    WardrobeService wardrobeService;

    @RequestMapping (path = "/api/clothing/all", method = RequestMethod.GET )
    public List<Clothing> getAllClothes(){
        return wardrobeService.get();
    }

    @RequestMapping (path = "/api/clothing/add", method = RequestMethod.POST)
    public void addClothes(Clothing clothing) {
        wardrobeService.add(clothing);
    }

    @RequestMapping(path = "/api/clothing/update", method = RequestMethod.PUT)
    public void updateClothing(Clothing clothing){
        wardrobeService.update(clothing);
    }

    @RequestMapping(path = "api/clothing/delete", method = RequestMethod.DELETE)
    public void deleteClothes(int id){
        wardrobeService.delete(id);
    }
}
