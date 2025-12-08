package com.team_06.schmendricks_weaponry.model;

import java.util.List;

public class CartSummary {

    private final double subtotal;
    private final double estimatedShipping;
    private final double estimatedTax;
    private final double total;
    private final List<CartItem> items;

    public CartSummary(List<CartItem> items, double estimatedShipping) {
        this.items = items;
        this.subtotal = items.stream().mapToDouble(CartItem::getPrice) .sum();
        this.estimatedTax = subtotal * 0.08;
        this.estimatedShipping = estimatedShipping;
        this.total = subtotal + estimatedShipping + estimatedTax;
    }

    public double getSubtotal() { return subtotal; }
    public double getEstimatedShipping() { return estimatedShipping; }
    public double getEstimatedTax() { return estimatedTax; }
    public double getTotal() { return total; }
    public List<CartItem> getItems() { return items; }
}

