package com.wardrobe.wardrobeapi.models;

public class Clothing {
    String name;
    int sleeveLength;
    int fabricWeight;

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
}
