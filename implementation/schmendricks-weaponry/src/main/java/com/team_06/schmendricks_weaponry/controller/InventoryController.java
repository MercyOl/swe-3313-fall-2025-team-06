package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.model.Item;
import com.team_06.schmendricks_weaponry.service.CartService;
import com.team_06.schmendricks_weaponry.service.InventoryService;
import com.team_06.schmendricks_weaponry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    private final CartService cartService;

    @Autowired
    private UserService userService;

    public InventoryController(InventoryService inventoryService, CartService cartService) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
    }

    @GetMapping
    public String inventoryPage(Model model, @RequestParam(required = false) String search) {
        // send the user to check if they can access sales report
        model.addAttribute("currentUser", userService.getCurrentUser());

        List<Item> items = inventoryService.getItems().stream()
                .filter(Item::isAvailable)
                .toList();

        if (search != null && !search.isEmpty()) {
            String lower = search.toLowerCase();
            items = items.stream()
                    .filter(i -> i.getName().toLowerCase().contains(lower))
                    .toList();
        }

        model.addAttribute("items", items);
        model.addAttribute("cartCount", cartService.getTotalQuantity());
        model.addAttribute("cartTotal", cartService.getTotalPrice());
        return "inventory";
    }

    @PostMapping("/add-to-cart/{id}")
    @ResponseBody
    public String addToCart(@PathVariable int id) {
        Item item = inventoryService.getItemById(id);
        if (item == null || !item.isAvailable()) return "error";

        cartService.addItem(item);       // add to cart
        inventoryService.setItemAvailable(id, false); // remove from inventory
        return "success";
    }
}


