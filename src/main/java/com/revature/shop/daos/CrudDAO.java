package com.revature.shop.daos;

import java.io.FileNotFoundException;
import java.util.List;

public interface CrudDAO <T> {
   int save(T obj);

   List<T> findAll() throws FileNotFoundException;

   T findById(int id);

   List<T> findAllById(int id);

   boolean update(T updatedObj);

   boolean removeById(String id);
}
