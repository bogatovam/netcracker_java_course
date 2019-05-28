package com.netcracker.services.impl;

import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.services.api.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CrudServiceImpl implements CrudService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public ResponseEntity<?> deleteAllCustomers() {
        customerRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body("All customers have been deleted");
    }

    @Override
    public ResponseEntity<?> deleteCustomer(Integer id) {
        try {
            Customer customer = getCustomer(id);
            customerRepository.delete(customer);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Customers with id: " + id + " is not exist");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Customers with id: " + id + " customers have been deleted");
    }
}
