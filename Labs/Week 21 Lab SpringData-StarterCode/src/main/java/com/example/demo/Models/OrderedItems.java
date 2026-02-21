package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // [cite: 64]
public class OrderedItems {
    @Id // [cite: 67]
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // [cite: 74]
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne // [cite: 75]
    @JoinColumn(name = "seller_produce_id")
    private SellerProduce sellerProduce;

    private Integer quantity;
    private Double priceAtOrder; // [cite: 57]

    public OrderedItems() {}

    public OrderedItems(Order order, SellerProduce sellerProduce, Integer quantity, Double priceAtOrder) {
        this.order = order;
        this.sellerProduce = sellerProduce;
        this.quantity = quantity;
        this.priceAtOrder = priceAtOrder;
    }

    // Getters and Setters [cite: 68]
    public Long getId() { return id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public SellerProduce getSellerProduce() { return sellerProduce; }
    public void setSellerProduce(SellerProduce sellerProduce) { this.sellerProduce = sellerProduce; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPriceAtOrder() { return priceAtOrder; }
    public void setPriceAtOrder(Double priceAtOrder) { this.priceAtOrder = priceAtOrder; }
}