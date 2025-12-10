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

    private String shippingOpt;

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

    // Form submission
    @PostMapping("/payment")
    public String continueToPayment(@RequestParam("shipping") String shipping) {
        // do any session/cart updates here
        return "redirect:/payment?shipping=" + shipping; // redirect to GET
    }

    // Page display
    @GetMapping("/payment")
    public String showPayment(@RequestParam("shipping") String shipping, Model model) {
        ShippingOption selectedShipping = ShippingOption.valueOf(shipping);
        shippingOpt = shipping;
        CartSummary cart = new CartSummary(cartService.getCurrentCart(), selectedShipping);

        model.addAttribute("shipping", selectedShipping);
        model.addAttribute("cart", cart);

        return "payment"; // payment.html
    }

    @GetMapping("/confirmation")
    public String showOrderConfirmation(Model model) {
        ShippingOption selectedShipping = ShippingOption.valueOf(shippingOpt);
        CartSummary orderSummary = new CartSummary(cartService.getCurrentCart(), selectedShipping);

        // --- Add essential order details to the model ---

        // Cart and Pricing Details (Needed for the right column summary)
        model.addAttribute("cart", orderSummary);

        // Customer and Order Details (Needed for the left column confirmation)
        model.addAttribute("customerEmail", "hero.link@hyrule.com");
        model.addAttribute("orderNumber", "#SW-000456");
        model.addAttribute("estimatedDelivery", "Thursday, Dec 11, 2025");
        model.addAttribute("shippingAddress", "123 Hero’s Way, Kennesaw, GA 30144");

        // New Fields for Confirmation Summary (Left Column)
        model.addAttribute("paymentMethod", "Visa ending in 4242");

        // Get the name from the ShippingOption enum for display
        ShippingOption shippingOption = ShippingOption.valueOf(orderSummary.getEstimatedShipping().toString().contains("29") ? "OVERNIGHT" : "GROUND");
        model.addAttribute("shippingMethodName", shippingOption.name().replace('_', ' ') + " - " + shippingOption.getCost().toPlainString());

        return "confirmation"; // Renders confirmation.html
    }


}
