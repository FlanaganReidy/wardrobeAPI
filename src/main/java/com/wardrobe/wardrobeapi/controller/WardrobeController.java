package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import com.wardrobe.wardrobeapi.service.WardrobeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WardrobeController {

    @RequestMapping (path = "/api/clothing", method = RequestMethod.GET )
    public List<Clothing> getAllClothes(){
        return WardrobeServiceImpl.get();
    }

}
