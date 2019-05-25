package com.netcracker.dao.api;

import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerDao extends CrudDao<Customer> {
    List<String> findAllByLastName(String lastName);
}
