package com.netcracker.dao.api;

import com.netcracker.model.Customer;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface CustomerDao extends CrudDao<Customer> {
    List<String> findUniqueDistrict();

    List<Pair<String, Double>> findNameAndSaleByDistrict(String district);

}
