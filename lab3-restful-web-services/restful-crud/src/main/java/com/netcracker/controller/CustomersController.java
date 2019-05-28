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
    @ApiOperation(value = "")
    List<Customer> getAllCustomers() {
        return crudService.getAllCustomers();
    }

    @GetMapping("/buyer/{id}")
    @ApiOperation(value = "")
    Customer getCustomerById(
            @ApiParam(value = "")
            @PathVariable Integer id) {
        return crudService.getCustomer(id);
    }

    @PostMapping("/buyer")
    @ApiOperation(value = "")
    Customer  createCustomer(
            @ApiParam(value = "")
            @RequestBody Customer customer) {
        return crudService.createCustomer(customer);
    }

    @DeleteMapping("/buyer")
    @ApiOperation(value = "")
    ResponseEntity<?> deleteAllCustomers() {
        return crudService.deleteAllCustomers();
    }

    @DeleteMapping("/buyer/{id}")
    @ApiOperation(value = "")
    ResponseEntity<?> deleteCustomerById(
            @ApiParam(value = "")
            @PathVariable Integer id) {
        return crudService.deleteCustomer(id);
    }
}
