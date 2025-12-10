package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.model.CartSummary;
import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.model.ShippingOption;
import com.team_06.schmendricks_weaponry.model.ShoppingCart;
import com.team_06.schmendricks_weaponry.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CheckOutController {

    @Autowired
    private CartService cartService;

    private ShoppingCart buildCart() {
        List<Item> items = cartService.getCartItems();
        return new ShoppingCart(items, 0); // user ID not needed for display
    }

    @GetMapping("/checkout")
    public String showCheckout(
            @RequestParam(value = "shipping", required = false, defaultValue = "GROUND") ShippingOption selectedShipping,
            Model model
    ) {
        ShoppingCart cart = buildCart();
        CartSummary cartSummary = new CartSummary(cart, selectedShipping);

        model.addAttribute("cart", cartSummary);
        model.addAttribute("selectedShipping", selectedShipping);
        return "checkout";
    }

    @PostMapping("/checkout/remove")
    public String removeItem(@RequestParam("itemId") int itemId) {
        cartService.removeItem(itemId);
        return "redirect:/checkout";
    }

    @PostMapping("/payment")
    public String continueToPayment(@RequestParam("shipping") ShippingOption selectedShipping) {
        // Save selected shipping to session/cart if needed
        return "redirect:/payment?shipping=" + selectedShipping.name();
    }
}
