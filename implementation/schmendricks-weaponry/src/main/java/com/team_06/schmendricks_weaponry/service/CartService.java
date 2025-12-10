package com.team_06.schmendricks_weaponry.service;

import com.team_06.schmendricks_weaponry.UserService;
import com.team_06.schmendricks_weaponry.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team_06.schmendricks_weaponry.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.io.File;
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

    @Autowired
    private UserService userService;

    ObjectMapper mapper = new ObjectMapper();
    File cartStorage = new File("src/main/resources/data/ShoppingCarts.json");

    public List<ShoppingCart> loadCarts(){
        try{

            return mapper.readValue(cartStorage, new TypeReference<List<ShoppingCart>>() { } );

        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<ShoppingCart>();
        }
    }

    public void saveCarts(List<ShoppingCart> carts){

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(cartStorage, carts);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createCart() {
        List<ShoppingCart> carts = loadCarts();
        ShoppingCart newCart = new ShoppingCart(new ArrayList<>(), carts.size());
        carts.add(newCart);
        saveCarts(carts);
    }


    // Returns the list of items currently in the cart.
    public List<Item> getCartItems() {
        ShoppingCart thisCart = loadCarts().get(userService.getCurrentUser().getUserId());
        return thisCart.getItems();
    }

    //Adds an item to the cart. Assumes duplicates are prevented by other logic.
    public void addItem(Item item) {
        List<ShoppingCart> carts = loadCarts();
        ShoppingCart thisCart = carts.get(userService.getCurrentUser().getUserId());
        thisCart.addItem(item);
        saveCarts(carts);
    }

    // Removes an item from the cart by its ID.
    public void removeItem(int id) {
        List<ShoppingCart> carts = loadCarts();
        ShoppingCart thisCart = carts.get(userService.getCurrentUser().getUserId());
        List<Item> items = thisCart.getItems();

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == id) {
                items.remove(i);
            }
        }

        saveCarts(carts);
    }

    // Calculates the total price of all items in the cart.
    public BigDecimal getTotalPrice() {
        ShoppingCart thisCart = loadCarts().get(userService.getCurrentUser().getUserId());
        List<Item> items = thisCart.getItems();

        BigDecimal totalPrice = new BigDecimal(0);

        for(int i = 0; i < items.size(); i++) {
            totalPrice = totalPrice.add(items.get(i).getPrice());
        }

        return totalPrice;
    }

    //Returns the total number of items in the cart.
    public int getTotalQuantity() {
        ShoppingCart thisCart = loadCarts().get(userService.getCurrentUser().getUserId());
        List<Item> items = thisCart.getItems();

        return items.size();
    }

    // Clears all items from the cart.
    public void clearCart() {
        List<ShoppingCart> carts = loadCarts();
        ShoppingCart thisCart = carts.get(userService.getCurrentUser().getUserId());
        List<Item> items = thisCart.getItems();

        items.clear();

        saveCarts(carts);
    }
}




