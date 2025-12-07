package com.example.demo.controller;

import com.example.demo.model.CartItem;
import com.example.demo.model.CartSummary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        // example data to match the screenshot
        CartSummary summary = new CartSummary(
                0.00,
                0.00,
                0.00,
                Arrays.asList(
                        new CartItem("Lorem ipsum dolor sit",
                                "Delivered WeekDay, Month Day",
                                0.00),
                        new CartItem("Lorem ipsum dolor sit",
                                "Delivered WeekDay, Month Day",
                                0.00)
                )
        );

        model.addAttribute("cart", summary);
        return "checkout";   // ==> templates/checkout.html
    }
}
