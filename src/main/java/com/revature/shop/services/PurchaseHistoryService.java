package com.revature.shop.services;

import com.revature.shop.daos.PurchaseHistoryDAO;

public class PurchaseHistoryService {
    public PurchaseHistoryDAO getPurchaseHistoryDAO() {
        return purchaseHistoryDAO;
    }

    public PurchaseHistoryService(PurchaseHistoryDAO purchaseHistoryDAO) {
        this.purchaseHistoryDAO = purchaseHistoryDAO;
    }

    private final PurchaseHistoryDAO purchaseHistoryDAO;


}
