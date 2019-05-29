package com.netcracker.service.api;

import com.netcracker.model.Shop;
import javafx.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DisplayDataService {
    List<String> findUniqueBookNames();

    List<Integer> findUniqueBookPrices();

    List<Integer> findUniquePurchaseMonth();

    List<String> findUniqueCustomerDistrict();

    List<Pair<String, Double>> findNameAndSaleByDistrict(String district);

    List<String> findNamesByDistricts(List<String> districts);

    List<Pair<String, Integer>> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price);

    List<Pair<String, String>> findCustomersAndShopsNames();

    String getAllDateLastNameSaleNameCount();

    Map<Integer, Pair<String, Date>> findIdLastNameDateByPrice(Integer price);

    List<String> findLastNameDistrictDateByMonth(Integer month);

    List<Shop> findShopsByDistrictAndSale();

    public List<String> findPurchaseByBooksStorageAndCount();

}
