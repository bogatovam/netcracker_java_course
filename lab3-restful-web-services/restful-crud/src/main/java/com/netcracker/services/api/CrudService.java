package com.netcracker.services.api;

import com.netcracker.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService {
    List<Customer> getAllCustomers();
    Customer getCustomer(Integer id);

    Customer createCustomer(Customer customer);

    ResponseEntity<?>  deleteAllCustomers();
    ResponseEntity<?>  deleteCustomer(Integer id);
}
