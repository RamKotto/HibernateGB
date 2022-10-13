package ru.saraev.products;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void delete(Long id);

    void saveOrUpdate(Product product);


}
