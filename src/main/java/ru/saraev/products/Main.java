package ru.saraev.products;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            Product product = productDao.findById(1L);
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
