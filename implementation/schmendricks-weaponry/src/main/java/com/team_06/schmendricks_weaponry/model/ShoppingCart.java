package com.team_06.schmendricks_weaponry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's shopping cart.
 * Stores a list of items and provides methods to add, remove,
 * and calculate totals for items in the cart.
 */
public class ShoppingCart {

    // List of items in the cart
    private List<Item> items = new ArrayList<>();

    private int cartId;

    // Get all items currently in the cart.

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public ShoppingCart(List<Item> i, int id){
        items = i;
        cartId = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCartId(){ return cartId; }

    //Add an item to the cart.
    public void addItem(Item item) {
        if (!items.contains(item)) { // prevent duplicates
            items.add(item);
        }
    }

    /**
     * Remove an item from the cart by its ID.
     * itemId ID of the item to remove
     */
    public void removeItem(int itemId) {
        items.removeIf(item -> item.getId() == itemId);
    }

    // Get the total number of items in the cart.
    @JsonIgnore
    public int getTotalQuantity() {
        return items.size();
    }

    /**
     * Calculate the total price of all items in the cart.
     * @return total price as BigDecimal
     */
    @JsonIgnore
    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Clear all items from the cart.

    public void clear() {
        items.clear();
    }

    public void setCartId(int id){
        cartId = id;
    }

    public void setItems(List<Item> items){
        this.items = items;
    }
}


