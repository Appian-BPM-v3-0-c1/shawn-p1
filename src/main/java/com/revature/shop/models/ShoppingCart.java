package com.revature.shop.models;

public class ShoppingCart {

    private int cartId;
    private String itemName;
    private int quantity;
    private float price;
    private int itemId;


    public ShoppingCart() {

    }

    public ShoppingCart(int cartId, String itemName, int quantity, float price, int itemId) {
        this.cartId = cartId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.itemId = itemId;

    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
