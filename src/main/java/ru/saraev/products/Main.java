package ru.saraev.products;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            Product product = productDao.findById(1L);
            System.out.println(product);

            List<Product> products = productDao.findAll();
            System.out.println(products);

            Product newProduct = new Product("Onion", 111);
            Product updateProduct = new Product(2L, "Potato", 111);
            productDao.saveOrUpdate(newProduct);
            productDao.saveOrUpdate(updateProduct);
            System.out.println(productDao.findAll());

            productDao.deleteById(1L);
            System.out.println(productDao.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
