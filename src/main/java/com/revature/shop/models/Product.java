package com.revature.shop.models;


public class Product {
    private int itemId;
    private String brand;
    private String itemName;
    private int quantity;
    private float price;
    private int localId;

    public Product() {
    }

    public Product(int itemId, String brand, String itemName, int quantity, float price, int localId) {
        this.itemId = itemId;
        this.brand = brand;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.localId = localId;

    }

    public int getItemId(int itemId) {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemId=" + itemId +
                ", brand='" + brand + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
