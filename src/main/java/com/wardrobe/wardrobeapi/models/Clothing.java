package com.wardrobe.wardrobeapi.models;


import com.wardrobe.wardrobeapi.Enums.Color;
import com.wardrobe.wardrobeapi.Enums.Mood;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
public class Clothing {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "sleeveLength")
    private Integer sleeveLength;
    @Column(name = "fabricWeight")
    private Integer fabricWeight;
    @Column(name = "isClean")
    Boolean isClean;
    @Column(name = "mood")
    Mood mood;
    @Column(name = "color")
    Color color;
    @Column(name="warmPoints")
    private Integer warmPoints;


    public Clothing() {
    }

    public Integer getWarmPoints() {
        return warmPoints;
    }

    public void setWarmPoints(Integer warmPoints) {
        this.warmPoints = warmPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public int getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(int sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public int getFabricWeight() {
        return fabricWeight;
    }

    public void setFabricWeight(int fabricWeight) {
        this.fabricWeight = fabricWeight;
    }

    public Boolean getClean() {
        return isClean;
    }

    public void setClean(Boolean clean) {
        isClean = clean;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void calcWarmPoints(){
        Integer warmPoints = 0;
        switch (this.fabricWeight){
            case 1: warmPoints = 40;
                break;
            case 2: warmPoints = 60;
                break;
            case 3: warmPoints = 80;
                break;
        }
        warmPoints += this.sleeveLength * 10;
        this.setWarmPoints(warmPoints);
    }
}
