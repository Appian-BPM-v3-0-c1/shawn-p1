package com.revature.shop.models;

public class PurchaseHistory {

    private int histId;
    private int userId;
    private int cartId;

    public PurchaseHistory() {

    }

    public PurchaseHistory(int histId, int userId, int cartId) {
        this.histId = histId;
        this.userId = userId;
        this.cartId = cartId;
    }



        public int getHistId() {
            return histId;
        }

        public void setHistId(int histId) {
            this.histId = histId;
        }

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
        }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}


