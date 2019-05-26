package com.netcracker.service.api;

import java.util.List;
import java.util.Map;

public interface DisplayUniqueDataService {
    List<String> findUniqueBookNames();

    List<Integer> findUniqueBookPrices();

    List<Integer> findUniquePurchaseMonth();

    List<String> findUniqueCustomerDistrict();

    Map<String, Double> findNameAndSaleByDistrict(String district);

    List<String> findNamesByDistricts(List<String> districts);

    public Map<String, Integer> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price);

}
