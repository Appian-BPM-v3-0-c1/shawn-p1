package com.revature.shop.daos;

import com.revature.shop.models.PurchaseHistory;
import com.revature.shop.services.PurchaseHistoryService;
import com.revature.shop.connection.DatabaseConnection;
import com.revature.shop.models.User;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseHistoryDAO implements CrudDAO<PurchaseHistory>{
    Connection con = DatabaseConnection.getCon();
    @Override
    public int save(PurchaseHistory obj) {
        return 0;
    }

    @Override
    public List<PurchaseHistory> findAll() throws FileNotFoundException {
        return null;
    }

    @Override
    public PurchaseHistory findById(int id) {
        return null;
    }

    @Override
    public List<PurchaseHistory> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(PurchaseHistory updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<PurchaseHistory> findHistoryById (int id) {
        List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM purchase_history WHERE user_id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory();
                User user = new User();

                purchaseHistory.setHistId(rs.getInt("hist_id"));
                purchaseHistory.setCartId(rs.getInt("cart_id"));
                purchaseHistory.setUserId(rs.getInt("user_id"));

                purchaseHistoryList.add(purchaseHistory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseHistoryList;
    }
}
