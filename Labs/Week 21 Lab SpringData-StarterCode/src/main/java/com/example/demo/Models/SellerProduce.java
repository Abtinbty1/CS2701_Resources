package com.example.demo.Models;

import jakarta.persistence.*;

@Entity // [cite: 64]
public class SellerProduce {
    @Id // [cite: 67]
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // [cite: 72]
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne // [cite: 72]
    @JoinColumn(name = "produce_id")
    private Produce produce;

    private Integer quantity; // 
    private Double price; // 

    public SellerProduce() {}

    public SellerProduce(User seller, Produce produce, Integer quantity, Double price) {
        this.seller = seller;
        this.produce = produce;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters [cite: 68]
    public Long getId() { return id; }
    public User getSeller() { return seller; }
    public void setSeller(User seller) { this.seller = seller; }
    public Produce getProduce() { return produce; }
    public void setProduce(Produce produce) { this.produce = produce; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}