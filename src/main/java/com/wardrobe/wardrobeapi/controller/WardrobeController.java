package com.wardrobe.wardrobeapi.controller;

import com.wardrobe.wardrobeapi.Enums.Color;
import com.wardrobe.wardrobeapi.Enums.Mood;
import com.wardrobe.wardrobeapi.entities.Clothing;
import com.wardrobe.wardrobeapi.entities.Photo;
import com.wardrobe.wardrobeapi.service.PhotoService;
import com.wardrobe.wardrobeapi.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WardrobeController{

    @Autowired
    WardrobeService wardrobeService;

    @Autowired
    PhotoService photoService;

    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "index";
    }
    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/clothing/all", method = RequestMethod.GET )
    @ResponseBody
    public List<Clothing> getAllClothes(){
        return wardrobeService.get();
    }
    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/clothing/item/{id}", method = RequestMethod.GET)
    public Clothing getOneClothingItem(@PathVariable("id") Integer id){
        return wardrobeService.getById(id);
    }
    @CrossOrigin
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
            clothing.setClean(true);
            clothing.calcWarmPoints();
            wardrobeService.add(clothing);
            return true;
        }
        catch(NullPointerException ex){
            System.out.print("\n name: " + name + "\n fabricWeight: " + fabricWeight +"\n sleeveLength: "+ sleeveLength);
            return false;
        }
    }
    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/clothing/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Clothing updateClothing(@PathVariable("id") Integer id, String name, Integer fabricWeight, Integer sleeveLength, String color, String mood){

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
            clothing.setClean(true);
            clothing.calcWarmPoints();
            wardrobeService.update(clothing);
        }
        catch(NullPointerException ex){
            return null;
        }

        return clothing;
    }
    @CrossOrigin
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
    @CrossOrigin
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
    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/clothing/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteClothes(@PathVariable("id") Integer id){
        wardrobeService.delete(id);
        return true;
    }
    @CrossOrigin
    @RequestMapping(produces = "application/json", path = "/clothing/todayslook/{temp}", method = RequestMethod.GET)
    public List<Clothing> getTodaysLook(@PathVariable("temp") Integer temp){

        return wardrobeService.get()
                .stream()
                .filter(e -> e.getWarmPoints()>=(temp - 10))
                .filter(e-> e.getWarmPoints()<=(temp +10))
                .collect(Collectors.toList());



    }
    @CrossOrigin
    @RequestMapping(produces = "application/json", path="/clothing/add/{id}/photo", method = RequestMethod.POST)
    public Clothing singleFileUpload(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        Clothing clothing = wardrobeService.getById(id);

        if (file.isEmpty()) {
            return null;
        }

        try {
            Photo photo = new Photo();
            clothing.setImage(photo);
            // Get the file and save it somewhere
            photo.setImage(file.getBytes());
            photoService.add(photo);

            wardrobeService.update(clothing);


            return clothing;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}