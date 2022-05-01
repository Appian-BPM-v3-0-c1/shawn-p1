package com.revature.shop.daos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.shop.connection.DatabaseConnection;
import com.revature.shop.models.Product;

public class ProductDAO implements CrudDAO<Product> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Product obj) {
        int n = 0;

    try {
        PreparedStatement ps = con.prepareStatement("INSERT into products (brand, name, quantity, price) VALUES (?, ?, ?, ?)");
        ps.setString(1, obj.getBrand());
        ps.setString(2, obj.getItemName());
        ps.setInt(3, obj.getQuantity());
        ps.setFloat(4, obj.getPrice());

        n = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return n;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setItemId(rs.getInt("item_id"));
                product.setBrand(rs.getString("brand"));
                product.setItemName(rs.getString("item_name"));
                product.setPrice(rs.getFloat("item_price"));
                product.setQuantity(rs.getInt("quantity"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAllById(int id) {

    return null;
    }

    @Override
    public boolean update(Product updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public boolean removeItemById(int ItemId) {

        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM shopping_carts WHERE item_id = ?");
//            ps.setInt(1, obj.getItemId);



            n = ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }

