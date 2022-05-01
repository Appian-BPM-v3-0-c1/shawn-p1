package com.revature.shop.daos;

import java.io.FileNotFoundException;
import java.util.List;

public class LocationDAO implements CrudDAO{
    @Override
    public int save(Object obj) {
        return 0;
    }

    @Override
    public List findAll() throws FileNotFoundException {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Object updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
