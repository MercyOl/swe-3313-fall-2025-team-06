package com.team_06.schmendricks_weaponry.service;

import com.team_06.schmendricks_weaponry.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for managing the user's shopping cart.
 * Stores cart items in session so each user has their own cart.
 */
@Service
@SessionScope
public class CartService {

    private final List<Item> cartItems = new ArrayList<>(); // List of items in the cart

    // Returns the list of items currently in the cart.
    public List<Item> getCartItems() {
        return cartItems;
    }

    //Adds an item to the cart. Assumes duplicates are prevented by other logic.
    public void addItem(Item item) {
        cartItems.add(item);
    }

    // Removes an item from the cart by its ID.
    public void removeItem(int id) {
        cartItems.removeIf(i -> i.getId() == id);
    }

    // Calculates the total price of all items in the cart.
    public BigDecimal getTotalPrice() {
        return cartItems.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Returns the total number of items in the cart.
    public int getTotalQuantity() {
        return cartItems.size();
    }

    // Clears all items from the cart.
    public void clearCart() {
        cartItems.clear();
    }
}




