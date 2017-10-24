package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.Enums.Color;
import com.wardrobe.wardrobeapi.Enums.Mood;
import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public boolean addClothes(String name, int fabricWeight, int sleeveLength, String mood, String color) {
        Clothing clothing = new Clothing();
        clothing.setName(name);
        clothing.setFabricWeight(fabricWeight);
        clothing.setSleeveLength(sleeveLength);
        switch (mood){
            case "Happy": clothing.setMood(Mood.HAPPY);
                break;
            case "Angry": clothing.setMood(Mood.ANGRY);
                break;
            case "Shy": clothing.setMood(Mood.SHY);
                break;
            case "Sexy": clothing.setMood(Mood.SEXY);
                break;
            case "Gloomy": clothing.setMood(Mood.GLOOMY);
                break;
        }
        switch (color){
            case "Red": clothing.setColor(Color.RED);
                break;
            case "Orange": clothing.setColor(Color.ORANGE);
                break;
            case "Yellow": clothing.setColor(Color.YELLOW);
                break;
            case "Green": clothing.setColor(Color.GREEN);
                break;
            case "Blue": clothing.setColor(Color.BLUE);
                break;
            case "Purple": clothing.setColor(Color.PURPLE);
                break;
            case "White": clothing.setColor(Color.WHITE);
                break;
            case "Black": clothing.setColor(Color.BLACK);
                break;
        }
        clothing.setClean(true);
        wardrobeService.add(clothing);
        return true;
    }

    @RequestMapping(produces = "application/json", path = "/clothing/update", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateClothing(Integer id){
        Clothing clothing = wardrobeService.getById(id);
        wardrobeService.update(clothing);
        return true;
    }

    @RequestMapping(produces = "application/json", path = "/clothing/color", method = RequestMethod.POST)
    @ResponseBody
    public List<Clothing> getAllColor(String color) {
        List<Clothing> byColor = new ArrayList();
        switch (color) {
            case "Red":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.RED)
                        .collect(Collectors.toList());
                break;
            case "Orange":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.ORANGE)
                        .collect(Collectors.toList());
                break;
            case "Yellow":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.YELLOW)
                        .collect(Collectors.toList());
                break;
            case "Green":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.GREEN)
                        .collect(Collectors.toList());
                break;
            case "Blue":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.BLUE)
                        .collect(Collectors.toList());
                break;
            case "Purple":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.PURPLE)
                        .collect(Collectors.toList());
                break;
            case "White":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.WHITE)
                        .collect(Collectors.toList());
                break;
            case "Black":
                byColor = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getColor() == Color.BLACK)
                        .collect(Collectors.toList());
                break;
        }

        return byColor;
    }
    @RequestMapping(produces = "application/json", path = "/clothing/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteClothes(Integer id){
        wardrobeService.delete(id);
        return true;
    }
}
