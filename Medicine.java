package com.example.pallabi.pharmiz;

public class Medicine {

    private String id;
    private String name;
    private String price;
    private String quantity;
    private String supplier;
    private String stockout;

    public Medicine(String id,String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStockout() {
        return stockout;
    }

    public void setStockout(String stockout) {
        this.stockout = stockout;
    }
}