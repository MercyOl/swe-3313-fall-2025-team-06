package com.team_06.schmendricks_weaponry.model;

import java.math.BigDecimal;

/*
 This class is meant to represent an item that is in the inventory
 Each item has an ID #, name, description, price, availability, and an image.
 Getters and setters are so we can read and update the item's info when needed,
 It also makes it easier for tasks that involve retrieving the item's data.
 */

public class Item {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private String image;

    public Item() {}

    public Item(int id, String name, String description, BigDecimal price, boolean isAvailable, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.image = image;
    }

    /*
     Getters and setters to read and updates items' info as needed.
     Necessary for updating inventory, marking items as unavailable, and for proper JSON serialization/deserialization.
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
