package com.team_06.schmendricks_weaponry.model;


public class  CartItem
{
    private String title;
    private String Description;
    private double price;


    public CartItem(String title, String Description, double price) {
        this.title = title;
        this.Description = Description;
        this.price = price;
    }


    public String getTitle() { return title; }
    public String getDescription() { return Description; }
    public double getPrice() { return price; }
}

