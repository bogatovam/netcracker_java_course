package com.netcracker.dao.api;

import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import javafx.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PurchaseDao extends CrudDao<Purchase> {
    List<Integer> findUniqueMonth();

    List<String> findCustomersNames();

    List<String> findShopsNames();

    List<Pair<String, String>> findCustomersAndShopsNames();

    Map<Integer, Pair<String, Date>> findIdLastNameDateByPrice(Integer price);

    List<String> findLastNameDistrictDateByMonth(Integer month);

    List<Shop> findShopsByDistrictAndSale();

    List<String> findPurchaseByBooksStorageAndCount();
}
