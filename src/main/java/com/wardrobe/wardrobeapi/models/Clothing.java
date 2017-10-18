package com.wardrobe.wardrobeapi.models;


import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
public class Clothing {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "sleeveLength")
    int sleeveLength;
    @Column(name = "fabricWeight")
    int fabricWeight;
    @Column(name = "isClean")
    Boolean isClean;
    @Column(name = "mood")
    Mood mood;
    @Column(name = "color")
    Color color;


    public Clothing() {
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
