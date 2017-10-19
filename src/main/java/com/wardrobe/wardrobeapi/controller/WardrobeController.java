package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.service.WardrobeService;
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
    public boolean addClothes(String name, int fabricWeight, int sleeveLength) {
        Clothing clothing = new Clothing();
        clothing.setName(name);
        clothing.setFabricWeight(fabricWeight);
        clothing.setSleeveLength(sleeveLength);
        clothing.setClean(true);
        wardrobeService.add(clothing);
        return true;
    }

    @RequestMapping(path = "/api/clothing/update", method = RequestMethod.PUT)
    public boolean updateClothing(Integer id){
        Clothing clothing = wardrobeService.getById(id);
        wardrobeService.update(clothing);
        return true;
    }

    @RequestMapping(path = "api/clothing/delete", method = RequestMethod.DELETE)
    public boolean deleteClothes(int id){
        wardrobeService.delete(id);
        return true;
    }
}
