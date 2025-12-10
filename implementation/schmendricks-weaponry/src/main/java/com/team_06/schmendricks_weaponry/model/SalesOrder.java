package com.team_06.schmendricks_weaponry.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesOrder {
    private int orderId;
    private int userId;
    private String date;
    private BigDecimal subtotal;
    private BigDecimal estimatedShipping;
    private BigDecimal estimatedTax;
    private BigDecimal total;

    public SalesOrder() {}

    public SalesOrder(int order_id, int user_id, String date, BigDecimal subtotal, BigDecimal estimatedShipping, BigDecimal estimatedTax, BigDecimal total) {
        this.orderId = order_id;
        this.userId = user_id;
        this.date = date;
        this.subtotal = subtotal;
        this.estimatedShipping = estimatedShipping;
        this.estimatedTax = estimatedTax;
        this.total = total;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int order_id) { this.orderId = order_id; }

    public int getUserId() { return userId; }
    public void setUserId(int user_id) { this.userId = user_id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public BigDecimal getEstimatedShipping() { return estimatedShipping; }
    public void setEstimatedShipping(BigDecimal estimatedShipping) { this.estimatedShipping = estimatedShipping; }

    public BigDecimal getEstimatedTax() { return estimatedTax; }
    public void setEstimatedTax(BigDecimal estimatedTax) { this.estimatedTax = estimatedTax; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}