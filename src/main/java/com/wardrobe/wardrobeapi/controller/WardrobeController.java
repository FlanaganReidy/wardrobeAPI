package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.Enums.Color;
import com.wardrobe.wardrobeapi.Enums.Mood;
import com.wardrobe.wardrobeapi.models.Clothing;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
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

    @RequestMapping(produces = "application/json", path = "/clothing/all", method = RequestMethod.GET )
    @ResponseBody
    public List<Clothing> getAllClothes(){
        return wardrobeService.get();
    }

    @RequestMapping(produces = "application/json", path = "/clothing/item", method = RequestMethod.GET)
    public Clothing getOneClothingItem(Integer id){
        return wardrobeService.getById(id);
    }

    @RequestMapping(produces = "application/json", path = "/clothing/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addClothes( String name, Integer fabricWeight, Integer sleeveLength, String color, String mood) {
        try {
            Clothing clothing = new Clothing();
            switch (color) {
                case "Red":
                    clothing.setColor(Color.RED);
                    break;
                case "Orange":
                    clothing.setColor(Color.ORANGE);
                    break;
                case "Yellow":
                    clothing.setColor(Color.YELLOW);
                    break;
                case "Green":
                    clothing.setColor(Color.GREEN);
                    break;
                case "Blue":
                    clothing.setColor(Color.BLUE);
                    break;
                case "Purple":
                    clothing.setColor(Color.PURPLE);
                    break;
                case "White":
                    clothing.setColor(Color.WHITE);
                    break;
                case "Black":
                    clothing.setColor(Color.BLACK);
                    break;
            }
            switch (mood) {
                case "Happy":
                    clothing.setMood(Mood.HAPPY);
                    break;
                case "Gloomy":
                    clothing.setMood(Mood.GLOOMY);
                    break;
                case "Sexy":
                    clothing.setMood(Mood.SEXY);
                    break;
                case "Angry":
                    clothing.setMood(Mood.ANGRY);
                    break;
                case "Shy":
                    clothing.setMood(Mood.SHY);
                    break;
            }

            clothing.setName(name);
            clothing.setFabricWeight(fabricWeight);
            clothing.setSleeveLength(sleeveLength);
            clothing.calcWarmPoints();
            clothing.setClean(true);
            wardrobeService.add(clothing);
            return true;
        }
        catch(NullPointerException ex){
            System.out.print("\n name: " + name + "\n fabricWeight: " + fabricWeight +"\n sleeveLength: "+ sleeveLength);
            return false;
        }
    }

    @RequestMapping(produces = "application/json", path = "clothing/update", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateClothing(Integer id, String name, Integer fabricWeight, Integer sleeveLength, String color, String mood){

        Clothing clothing = wardrobeService.getById(id);
        try {
            switch (color) {
                case "Red":
                    clothing.setColor(Color.RED);
                    break;
                case "Orange":
                    clothing.setColor(Color.ORANGE);
                    break;
                case "Yellow":
                    clothing.setColor(Color.YELLOW);
                    break;
                case "Green":
                    clothing.setColor(Color.GREEN);
                    break;
                case "Blue":
                    clothing.setColor(Color.BLUE);
                    break;
                case "Purple":
                    clothing.setColor(Color.PURPLE);
                    break;
                case "White":
                    clothing.setColor(Color.WHITE);
                    break;
                case "Black":
                    clothing.setColor(Color.BLACK);
                    break;
            }
            switch (mood) {
                case "Happy":
                    clothing.setMood(Mood.HAPPY);
                    break;
                case "Gloomy":
                    clothing.setMood(Mood.GLOOMY);
                    break;
                case "Sexy":
                    clothing.setMood(Mood.SEXY);
                    break;
                case "Angry":
                    clothing.setMood(Mood.ANGRY);
                    break;
                case "Shy":
                    clothing.setMood(Mood.SHY);
                    break;
            }

            clothing.setName(name);
            clothing.setFabricWeight(fabricWeight);
            clothing.setSleeveLength(sleeveLength);
            clothing.calcWarmPoints();
            clothing.setClean(true);
            wardrobeService.update(clothing);
        }
        catch(NullPointerException ex){
            return false;
        }

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

    @RequestMapping(produces = "application/json", path = "clothing/")

    @RequestMapping(produces = "application/json", path = "clothing/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteClothes(int id){
        wardrobeService.delete(id);
        return true;
    }
}