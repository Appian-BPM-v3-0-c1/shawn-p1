package com.revature.shop.daos;

import com.revature.shop.models.PurchaseHistory;
import com.revature.shop.models.ShoppingCart;
import com.revature.shop.services.ShoppingCartService;
import com.revature.shop.connection.DatabaseConnection;
import com.revature.shop.models.Product;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;


public class ShoppingCartDAO implements CrudDAO<ShoppingCart>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(ShoppingCart obj) {
    int n = 0;

    try {
        PreparedStatement ps = con.prepareStatement("INSERT INTO shopping_carts(cart_id, item_name, item_price, quantity, item_id) VALUES (?, ?, ?, ?, ?)");

                ps.setInt(1, obj.getCartId());
                ps.setString(2, obj.getItemName());
                ps.setFloat(3,obj.getPrice());
                ps.setInt(4, obj.getQuantity());
                ps.setInt(5, obj.getItemId());


                n = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return n;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public ShoppingCart findById(int id) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(ShoppingCart updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<ShoppingCart> findCartById (int id) {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shopping_carts WHERE item_id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ShoppingCart shoppingCart = new ShoppingCart();

                shoppingCart.setCartId(rs.getInt("cart_id"));
                shoppingCart.setItemName(rs.getString("item_name"));
                shoppingCart.setQuantity(rs.getInt("quantity"));
                shoppingCart.setPrice(rs.getFloat("price"));
                shoppingCart.setItemId(rs.getInt("item_id"));

                shoppingCartList.add(shoppingCart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCartList;
    }
}
