package com.wardrobe.wardrobeapi.entities;

import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="image")
    private byte[] image;

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}