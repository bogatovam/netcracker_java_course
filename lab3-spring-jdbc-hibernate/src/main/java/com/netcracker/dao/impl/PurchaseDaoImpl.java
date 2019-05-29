package com.netcracker.dao.impl;

import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import javafx.util.Pair;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Data
@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl extends BaseDao<Purchase> implements PurchaseDao {

    @Override
    public List<Integer> findUniqueMonth() {
        List<Integer> result = new ArrayList<>();
        List<Date> dates = getSession().createQuery("SELECT distinct date FROM Purchase").list();

        dates.forEach(date -> result.add(date.getMonth()));
        return result;
    }

    @Override
    public List<Pair<String, String>> findCustomersAndShopsNames() {
        List<Pair<String, String>> result = new ArrayList<>();

        List<Purchase> purchases = findAll();
        purchases.forEach(purchase -> result.add(
                new Pair<>(purchase.getCustomer().getLastName(), purchase.getSeller().getName())));

        return result;
    }

    @Override
    public List<String> findCustomersNames() {
        List<String> result = new ArrayList<>();
        List<Purchase> purchases = findAll();
        purchases.forEach(purchase -> result.add(purchase.getCustomer().getLastName()));
        return result;
    }

    @Override
    public List<String> findShopsNames() {
        List<String> result = new ArrayList<>();
        List<Purchase> purchases = findAll();
        purchases.forEach(purchase -> result.add(purchase.getSeller().getName()));
        return result;
    }

    @Override
    public Map<Integer, Pair<String, Date>> findIdLastNameDateByPrice(Integer price) {
        Map<Integer, Pair<String, Date>> result = new HashMap<>();
        List<Purchase> purchases = getSession().createQuery("FROM Purchase WHERE price >= :price")
                .setInteger("price", price).list();
        purchases.forEach(purchase -> result.put(purchase.getId(),
                new Pair<>(purchase.getCustomer().getLastName(), purchase.getDate())));
        return result;
    }

    @Override
    public List<String> findLastNameDistrictDateByMonth(Integer month) {
        List<String> result = new ArrayList<>();

        List<Purchase> purchases = getSession().createQuery("SELECT p FROM Purchase p JOIN p.customer JOIN p.seller " +
                "WHERE p.customer.district = p.seller.district AND " +
                "EXTRACT(MONTH FROM p.date) >= :month " +
                "ORDER BY p.date")
                .setInteger("month", month)
                .list();
        purchases.forEach(p -> result.add("\n Customers lastName:  " + p.getCustomer().getLastName() +
                ", Customers district: " + p.getCustomer().getDistrict() +
                ", Purchases date:  " + p.getDate().toString() ));
        return result;
    }

    @Override
    public List<Shop> findShopsByDistrictAndSale() {
        List<Shop> shops = getSession().createQuery("SELECT p.seller FROM Purchase p JOIN p.customer JOIN p.seller " +
                "WHERE p.seller.district NOT IN ('Avtozavodskiy') AND " +
                "p.customer.sale BETWEEN 0.10 AND 0.15")
                .list();
        return shops;
    }

    @Override
    public List<String> findPurchaseByBooksStorageAndCount() {
        List<String> result = new ArrayList<>();

        List<Purchase> purchases = getSession().createQuery("SELECT p FROM Purchase p JOIN p.customer JOIN p.seller " +
                "WHERE p.book.storage = p.seller.district AND " +
                "p.book.count > 10 "+
                "ORDER BY p.price ASC")
                .list();
        purchases.forEach(p -> result.add("\n Books name:  " + p.getBook().getName() +
                ", Books storage: " + p.getBook().getStorage() +
                ", Books count:  " + p.getBook().getCount() +
                ", Price: "  + p.getPrice()));
        return result;
    }
}
