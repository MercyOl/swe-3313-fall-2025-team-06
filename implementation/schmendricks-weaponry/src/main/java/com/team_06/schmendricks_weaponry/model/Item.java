package com.team_06.schmendricks_weaponry.model;

import java.math.BigDecimal;

/**
 * Represents an item in the shop.
 * Stores basic details like id, name, description, price, availability, and image.
 */
public class Item {
    // Unique identifier for the item
    private int id;

    // Name of the item
    private String name;

    // Description of the item
    private String description;

    // Price of the item
    private BigDecimal price;

    // Availability status (true if in not in cart)
    private boolean available;

    // Image URL or path for the item
    private String image;

    // Default constructor
    public Item() {}

    // Constructor with all fields
    public Item(int id, String name, String description, BigDecimal price, boolean available, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.image = image;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
