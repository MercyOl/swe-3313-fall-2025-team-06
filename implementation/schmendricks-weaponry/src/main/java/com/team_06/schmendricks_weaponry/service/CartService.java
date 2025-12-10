package com.team_06.schmendricks_weaponry.service;

import com.team_06.schmendricks_weaponry.UserService;
import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.model.ShoppingCart;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {

    @Autowired
    private UserService userService;

    private final ObjectMapper mapper = new ObjectMapper();
    private final File cartStorage = new File("src/main/resources/data/ShoppingCarts.json");

    private List<ShoppingCart> carts;

    public CartService() {
        carts = loadCarts();
    }

    private List<ShoppingCart> loadCarts() {
        try {
            return mapper.readValue(cartStorage, new TypeReference<List<ShoppingCart>>() {});
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    private void saveCarts() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(cartStorage, carts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ShoppingCart getCurrentCart() {
        int userId = userService.getCurrentUser().getUserId();
        while (carts.size() <= userId) {
            carts.add(new ShoppingCart(new ArrayList<>(), carts.size()));
        }
        return carts.get(userId);
    }

    public List<Item> getCartItems() {
        return getCurrentCart().getItems();
    }

    public void addItem(Item item) {
        ShoppingCart cart = getCurrentCart();
        cart.addItem(item);
        saveCarts();
    }

    public void removeItem(int id) {
        ShoppingCart cart = getCurrentCart();
        cart.getItems().removeIf(item -> item.getId() == id);
        saveCarts();
    }

    public BigDecimal getTotalPrice() {
        return getCurrentCart().getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getTotalQuantity() {
        return getCurrentCart().getItems().size();
    }

    public void clearCart() {
        getCurrentCart().getItems().clear();
        saveCarts();
    }
}





