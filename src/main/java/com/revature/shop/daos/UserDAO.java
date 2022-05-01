package com.revature.shop.daos;

import com.revature.shop.models.User;
import com.revature.shop.connection.DatabaseConnection;

import java.io.FileNotFoundException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements CrudDAO<User> {
    Connection con = DatabaseConnection.getCon();

    @Override

    public int save(User obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, password, address, email, first_name, last_name, city, state) VALUES (?, ?, ?, ? , ?, ?, ?, ?)");

            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getFirstName());
            ps.setString(4, obj.getLastName());
            ps.setString(5, obj.getAddress());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getCity());
            ps.setString(8, obj.getState());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<User> findAll() throws FileNotFoundException {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUserNames() {
        List<String> username_list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                username_list.add(rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username_list;
    }

    public int getUserId(String username) {
        int userId = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (user_id) FROM users where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }
    public User findByUsername(String username) {

        User user = new User();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

