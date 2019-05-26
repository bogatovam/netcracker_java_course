package com.netcracker.service.impl;

import com.netcracker.dao.api.BookDao;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.dao.api.ShopDao;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.api.CrudService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service("crudService")
@RequiredArgsConstructor
public class CrudServiceImpl implements CrudService {
    @Autowired
    BookDao bookDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    ShopDao shopDao;

    @Override
    public Optional<Book> findBook(Integer id) {
        return bookDao.find(id);
    }

    @Override
    public void saveBook(Book model) {
        bookDao.save(model);
    }

    @Override
    public void updateBook(Book model) {
        bookDao.update(model);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public Long countBook() {
        return bookDao.count();
    }

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAll();
    }

    @Override
    public Optional<Customer> findCustomer(Integer id) {
        return customerDao.find(id);
    }

    @Override
    public void saveCustomer(Customer model) {
        customerDao.save(model);
    }

    @Override
    public void updateCustomer(Customer model) {
        customerDao.update(model);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.delete(id);
    }

    @Override
    public Long countCustomer() {
        return customerDao.count();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Purchase> findPurchase(Integer id) {
        return purchaseDao.find(id);
    }

    @Override
    public void savePurchase(Purchase model) {
        purchaseDao.save(model);
    }

    @Override
    public void updatePurchase(Purchase model) {
        purchaseDao.update(model);
    }

    @Override
    public void deletePurchase(Integer id) {
        purchaseDao.delete(id);
    }

    @Override
    public Long countPurchase() {
        return purchaseDao.count();
    }

    @Override
    public List<Purchase> findAllPurchase() {
        return purchaseDao.findAll();
    }

    @Override
    public Optional<Shop> findShop(Integer id) {
        return shopDao.find(id);
    }

    @Override
    public void saveShop(Shop model) {
        shopDao.save(model);
    }

    @Override
    public void updateShop(Shop model) {
        shopDao.update(model);
    }

    @Override
    public void deleteShop(Integer id) {
        shopDao.delete(id);
    }

    @Override
    public Long countShop() {
        return shopDao.count();
    }

    @Override
    public List<Shop> findAllShop() {
        return shopDao.findAll();
    }
}
