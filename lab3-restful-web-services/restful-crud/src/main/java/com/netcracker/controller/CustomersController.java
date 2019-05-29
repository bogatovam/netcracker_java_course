package com.netcracker.controller;

import com.netcracker.model.Customer;
import com.netcracker.services.api.CrudService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomersController {

    @Autowired
    CrudService crudService;

    @GetMapping("/buyer")
    @ApiOperation(value = "Return list of customers")
    List<Customer> getAllCustomers() {
        return crudService.getAllCustomers();
    }

    @GetMapping("/buyer/{id}")
    @ApiOperation(value = "Return customer by id")
    Customer getCustomerById(
            @ApiParam(value = "customers id")
            @PathVariable Integer id) {
        return crudService.getCustomer(id);
    }

    @PostMapping("/buyer")
    @ApiOperation(value = "Create customer")
    Customer  createCustomer(
            @ApiParam(value = "Customers model")
            @RequestBody Customer customer) {
        return crudService.createCustomer(customer);
    }

    @DeleteMapping("/buyer")
    @ApiOperation(value = "Delete all customers from DB")
    ResponseEntity<?> deleteAllCustomers() {
        return crudService.deleteAllCustomers();
    }

    @DeleteMapping("/buyer/{id}")
    @ApiOperation(value = "Delete customer by id")
    ResponseEntity<?> deleteCustomerById(
            @ApiParam(value = "customers id")
            @PathVariable Integer id) {
        return crudService.deleteCustomer(id);
    }
}
