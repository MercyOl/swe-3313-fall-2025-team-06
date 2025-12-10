package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for handling shopping cart and actions.
 * Viewing the cart and removing items.
 */
@Controller
public class CartController {

    private final CartService cartService; // Service managing the session cart

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //Returns the cart page view with current items and total price.

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("items", cartService.getCartItems());
        model.addAttribute("cartTotal", cartService.getTotalPrice());
        return "cart";
    }

    /**
     * Handles requests to remove an item by ID from the cart.
     * Returns the updated cart total in JSON format.
     */
    @PostMapping("/cart/remove/{id}")
    @ResponseBody
    public Map<String, Object> removeItemAjax(@PathVariable int id) {
        cartService.removeItem(id);
        Map<String, Object> response = new HashMap<>();
        response.put("total", cartService.getTotalPrice());
        return response;
    }
}




