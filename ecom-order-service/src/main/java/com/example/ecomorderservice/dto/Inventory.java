package com.example.ecomorderservice.dto;

public class Inventory {

    private long product_id;
    private int quantity;

    public Inventory() {
    }

    public Inventory(long product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId='" + product_id + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}