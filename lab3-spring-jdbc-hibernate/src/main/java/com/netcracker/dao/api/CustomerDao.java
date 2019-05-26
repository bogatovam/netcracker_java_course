package com.netcracker.dao.api;

import com.netcracker.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao extends CrudDao<Customer> {
    List<String> findUniqueDistrict();

    Map<String, Double> findNameAndSaleByDistrict(String district);

}
