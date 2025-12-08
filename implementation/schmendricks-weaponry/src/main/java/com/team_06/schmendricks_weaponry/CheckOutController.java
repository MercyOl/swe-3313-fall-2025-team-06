package com.team_06.schmendricks_weaponry;

import com.team_06.schmendricks_weaponry.model.CartItem;
import com.team_06.schmendricks_weaponry.model.CartSummary;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class CheckOutController {

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        List<CartItem> items = List.of(
                new CartItem("Knife", "Short, cheap blade. Good as a sidearm.", 10.00),
                new CartItem("Shortsword", "A lightweight, versatile sword", 40.00)
        );

        CartSummary cart = new CartSummary(
                items,
                15.00
        );

        model.addAttribute("cart", cart);
        return "checkout";
    }

    @GetMapping("/payment")
    public String showPaymentPage(Model model) {
        List<CartItem> items = List.of(
                new CartItem("Knife", "Short, cheap blade. Good as a sidearm.", 10.00),
                new CartItem("Shortsword", "A lightweight, versatile sword", 40.00)
        );

        CartSummary cart = new CartSummary(items, 15.00);

        model.addAttribute("cart", cart);

        return "payment"; // this should match your payment.html page name
    }
    @GetMapping("/confirmation")
    public String showConfirmation(Model model) {

        List<CartItem> items = List.of(
                new CartItem("Knife", "Short, cheap blade. Good as a sidearm.", 10.00),
                new CartItem("Shortsword", "A lightweight, versatile sword", 40.00)
        );

        CartSummary cart = new CartSummary(items, 15.00);

        model.addAttribute("cart", cart);
        model.addAttribute("orderNumber", "SW-000123");
        model.addAttribute("customerEmail", "hero@example.com");
        model.addAttribute("estimatedDelivery", "Wednesday, Oct 23 – Friday, Oct 25");
        model.addAttribute("shippingAddress", "123 Hero's Way, Kennesaw, GA");

        return "confirmation";
    }
}
