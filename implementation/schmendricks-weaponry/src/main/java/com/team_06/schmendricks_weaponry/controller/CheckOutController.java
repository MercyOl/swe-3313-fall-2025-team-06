package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.model.CartItem;
import com.team_06.schmendricks_weaponry.model.CartSummary;

import java.math.BigDecimal;
import java.util.List;

import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.model.ShoppingCart;
import com.team_06.schmendricks_weaponry.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CheckOutController {

    @Autowired
    public CartService cartService;

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        CartSummary cart = new CartSummary(cartService.getCurrentShoppingCart(), new BigDecimal(15.00));

        model.addAttribute("cart", cart);

        return "checkout";
    }


    @GetMapping("/payment")
    public String showPaymentPage(Model model) {
        CartSummary cart = new CartSummary(cartService.getCurrentShoppingCart(), new BigDecimal(15.00));

        model.addAttribute("cart", cart);


        return "payment"; // this should match your payment.html page name
    }
    @GetMapping("/confirmation")
    public String showConfirmation(Model model) {
        CartSummary cart = new CartSummary(cartService.getCurrentShoppingCart(), new BigDecimal(15.00));

        model.addAttribute("cart", cart);
        model.addAttribute("orderNumber", "SW-000123");
        model.addAttribute("customerEmail", "hero@example.com");
        model.addAttribute("estimatedDelivery", "Wednesday, Oct 23 – Friday, Oct 25");
        model.addAttribute("shippingAddress", "123 Hero's Way, Kennesaw, GA");


        return "confirmation";
    }
}
