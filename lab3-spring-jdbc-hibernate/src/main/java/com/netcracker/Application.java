package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.api.CrudService;
import com.netcracker.service.api.DisplayDataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        CrudService crudService = (CrudService) context.getBean("crudService");
        DisplayDataService dataService = (DisplayDataService) context.getBean("dataService");

        System.out.println("\n------------------------------Test CRUD service------------------------------\n");
        testCrud(crudService);

        System.out.println("\n-----------------------------------Task #2-----------------------------------\n");
        System.out.println(dataService.findUniqueBookNames()+"\n");
        System.out.println(dataService.findUniqueBookPrices()+"\n");
        System.out.println(dataService.findUniqueCustomerDistrict()+"\n");
        System.out.println(dataService.findUniquePurchaseMonth()+"\n");

        System.out.println("\n-----------------------------------Task #3-----------------------------------\n");
        System.out.println(dataService.findNameAndSaleByDistrict("Nizhegorodskiy")+"\n");

        List<String> districts = new ArrayList<>();
        districts.add("Sormovskiy");
        districts.add("Sovetskiy");
        System.out.println(dataService.findNamesByDistricts(districts)+"\n");

        System.out.println(dataService.findNameAndPriceByNameAndPrice(
                "Windows", 20000)+"\n");

        System.out.println("\n-----------------------------------Task #4-----------------------------------\n");

        System.out.println(dataService.findCustomersAndShopsNames()+"\n");
        System.out.println(dataService.getAllDateLastNameSaleNameCount()+"\n");

        System.out.println("\n-----------------------------------Task #5-----------------------------------\n");

        System.out.println(dataService.findIdLastNameDateByPrice(60000)+"\n");
        System.out.println(dataService.findLastNameDistrictDateByMonth(3)+"\n");
        System.out.println(dataService.findShopsByDistrictAndSale()+"\n");
        System.out.println(dataService.findPurchaseByBooksStorageAndCount()+"\n");
    }

    public static void testCrud(CrudService crudService) {
        crudService.saveBook(Book.builder().name("To have or to be?").storage("Sormovskiy").count(10).price(180).build());
        System.out.println("Saved Book: " + crudService.findBook(crudService.countBook().intValue()).get());
        crudService.updateBook(Book.builder().id(crudService.countBook().intValue()).name("To have or to be?").storage("Sovetskiy").count(10).price(2380).build());
        System.out.println("Updated book: " + crudService.findBook(crudService.countBook().intValue()).get());

        crudService.saveCustomer(Customer.builder().lastName("Neivanov").district("Sovetskiy").sale(0.2).build());

        crudService.saveShop(Shop.builder().name("Good Book").district("Sormovskiy").commission(0.3).build());

        crudService.savePurchase(
                Purchase.builder().book(crudService.findBook(5).get())
                        .customer(crudService.findCustomer(7).get())
                        .seller(crudService.findShop(3).get())
                        .count(1).price(3332).date(new Date()).build()
        );
    }
}
