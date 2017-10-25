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

    @RequestMapping(produces = "application/json", path = "/clothing/all", method = RequestMethod.GET )
    @ResponseBody
    public List<Clothing> getAllClothes(){
        return wardrobeService.get();
    }

    @RequestMapping(produces = "application/json", path = "/clothing/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addClothes( String name, Integer fabricWeight, Integer sleeveLength) {
        try {
            Clothing clothing = new Clothing();
            clothing.setName(name);
            clothing.setFabricWeight(fabricWeight);
            clothing.setSleeveLength(sleeveLength);
            clothing.setClean(true);
            wardrobeService.add(clothing);
            return true;
        }
        catch(NullPointerException ex){
            System.out.print("\n name: " + name + "\n fabricWeight: " + fabricWeight +"\n sleeveLength: "+ sleeveLength);
            return false;
        }
    }

    @RequestMapping(produces = "application/json", path = "/api/clothing/update", method = RequestMethod.PUT)
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
    @RequestMapping(produces = "application/json", path = "/clothing/mood", method = RequestMethod.POST)
    @ResponseBody
    public List<Clothing> getAllMood(String mood) {
        List<Clothing> byMood = new ArrayList();
        switch (mood) {
            case "Happy":
                byMood = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getMood() == Mood.HAPPY)
                        .collect(Collectors.toList());
                break;
            case "Gloomy":
                byMood = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getMood() == Mood.GLOOMY)
                        .collect(Collectors.toList());
                break;
            case "Sexy":
                byMood = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getMood() == Mood.SEXY)
                        .collect(Collectors.toList());
                break;
            case "Angry":
                byMood = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getMood() == Mood.ANGRY)
                        .collect(Collectors.toList());
                break;
            case "Shy":
                byMood = wardrobeService.get()
                        .stream()
                        .filter(e -> e.getMood() == Mood.SHY)
                        .collect(Collectors.toList());
                break;
        }

        return byMood;
    }
    @RequestMapping(produces = "application/json", path = "api/clothing/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteClothes(int id){
        wardrobeService.delete(id);
        return true;
    }
}