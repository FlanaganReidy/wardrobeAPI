package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://tunic-wardrobe-api.herokuapp.com", maxAge = 3600)
@RestController
public class WardrobeController{

    @Autowired
    WardrobeService wardrobeService;


    @RequestMapping(produces = "application/json", path = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping (produces = "application/json", path = "/clothing/all", method = RequestMethod.GET )
    @ResponseBody
    public List<Clothing> getAllClothes(){
        return wardrobeService.get();
    }

    @RequestMapping (produces = "application/json", path = "/clothing/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addClothes(String name, Integer fabricWeight, Integer sleeveLength) {
        Clothing clothing = new Clothing();
        clothing.setName(name);
        clothing.setFabricWeight(fabricWeight);
        clothing.setSleeveLength(sleeveLength);
        clothing.setClean(true);
        wardrobeService.add(clothing);
        return true;
    }

    @RequestMapping(produces = "application/json", path = "/api/clothing/update", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateClothing(Integer id){
        Clothing clothing = wardrobeService.getById(id);
        wardrobeService.update(clothing);
        return true;
    }

    @RequestMapping(produces = "application/json", path = "api/clothing/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteClothes(int id){
        wardrobeService.delete(id);
        return true;
    }
}