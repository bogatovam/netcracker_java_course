package com.netcracker.service.api;

import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;

import java.util.List;
import java.util.Optional;

public interface CrudService {
    Optional<Book> findBook(Integer id);
    void saveBook(Book model);
    void updateBook(Book model);
    void deleteBook(Integer id);
    Long countBook();
    List<Book> findAllBook();

    Optional<Customer> findCustomer(Integer id);
    void saveCustomer(Customer model);
    void updateCustomer(Customer model);
    void deleteCustomer(Integer id);
    Long countCustomer();
    List<Customer> findAllCustomer();

    Optional<Purchase> findPurchase(Integer id);
    void savePurchase(Purchase model);
    void updatePurchase(Purchase model);
    void deletePurchase(Integer id);
    Long countPurchase();
    List<Purchase> findAllPurchase();

    Optional<Shop> findShop(Integer id);
    void saveShop(Shop model);
    void updateShop(Shop model);
    void deleteShop(Integer id);
    Long countShop();
    List<Shop> findAllShop();
}
