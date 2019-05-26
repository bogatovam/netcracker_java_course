package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.api.CrudService;
import com.netcracker.service.api.DisplayUniqueDataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    public static final Logger logger = Logger.getLogger("Application");

    public static void main(String[] args) {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        CrudService crudService = (CrudService) context.getBean("crudService");
        DisplayUniqueDataService task2Service = (DisplayUniqueDataService) context.getBean("task2Service");
        logger.info(task2Service.findUniqueBookNames().toString());
        logger.info(task2Service.findUniqueBookPrices().toString());
        logger.info(task2Service.findUniqueCustomerDistrict().toString());
        logger.info(task2Service.findUniquePurchaseMonth().toString());
        logger.info(task2Service.findNameAndSaleByDistrict("Nizhegorodskiy").toString());

        List<String> districts = new ArrayList<>();
        districts.add("Sormovskiy");
        districts.add("Sovetskiy");
        logger.info(task2Service.findNamesByDistricts(districts).toString());
        logger.info(task2Service.findNameAndPriceByNameAndPrice("Windows", 20000).toString());

        // fillBase(crudService);

    }

    public static void fillBase(CrudService crudService) {
        crudService.saveBook(Book.builder().name("Clockwork Orange").storage("Sormovskiy").count(10).price(180).build());
        crudService.saveBook(Book.builder().name("Art of programming").storage("Sormovskiy").count(25).price(3100).build());
        crudService.saveBook(Book.builder().name("War and Peace").storage("Nizhegorodskiy").count(31).price(31450).build());
        crudService.saveBook(Book.builder().name("100 years of loneliness").storage("Nizhegorodskiy").count(33).price(1450).build());
        crudService.saveBook(Book.builder().name("Crime and Punishment").storage("Avtozavodskiy").count(45).price(950).build());
        crudService.saveBook(Book.builder().name("Norwegian Forest").storage("Avtozavodskiy").count(24).price(640).build());
        crudService.saveBook(Book.builder().name("Dandelion Wine").storage("Sovetskiy").count(15).price(430).build());
        crudService.saveBook(Book.builder().name("Introduction to Psychoanalysis").storage("Sovetskiy").count(17).price(300).build());
        crudService.saveBook(Book.builder().name("Harry potter and the philosopher's stone").storage("Sovetskiy").count(8).price(1000).build());
        crudService.saveBook(Book.builder().name("Windows for lousers").storage("students").count(8).price(1000).build());

        crudService.saveCustomer(Customer.builder().lastName("Ivanov").district("Sovetskiy").sale(0.2).build());
        crudService.saveCustomer(Customer.builder().lastName("Volkov").district("Sovetskiy").sale(0.65).build());
        crudService.saveCustomer(Customer.builder().lastName("Volkova").district("Sovetskiy").sale(0.23).build());
        crudService.saveCustomer(Customer.builder().lastName("Sidorova").district("Sovetskiy").sale(0.53).build());
        crudService.saveCustomer(Customer.builder().lastName("Petrov").district("Avtozavodskiy").sale(0.54).build());
        crudService.saveCustomer(Customer.builder().lastName("Petrova").district("Avtozavodskiy").sale(0.3).build());
        crudService.saveCustomer(Customer.builder().lastName("Beglov").district("Avtozavodskiy").sale(0.7).build());
        crudService.saveCustomer(Customer.builder().lastName("Krupnov").district("Sormovskiy").sale(0.2).build());
        crudService.saveCustomer(Customer.builder().lastName("Sizov").district("Sormovskiy").sale(0.2).build());
        crudService.saveCustomer(Customer.builder().lastName("Sergeeva").district("Sormovskiy").sale(0.4).build());
        crudService.saveCustomer(Customer.builder().lastName("Mironova").district("Nizhegorodskiy").sale(0.35).build());

        crudService.saveShop(Shop.builder().name("Chitay-gorod").district("Sovetskiy").commission(0.3).build());
        crudService.saveShop(Shop.builder().name("Dirizhabl'").district("Avtozavodskiy").commission(0.1).build());
        crudService.saveShop(Shop.builder().name("Book House").district("Sormovskiy").commission(0.3).build());
        crudService.saveShop(Shop.builder().name("Book Shop").district("Nizhegorodskiy").commission(0.2).build());

        crudService.savePurchase(
                Purchase.builder().book(crudService.findBook(1).get())
                        .customer(crudService.findCustomer(3).get())
                        .seller(crudService.findShop(4).get())
                        .count(2).price(332).date(new Date()).build()
        );
        crudService.savePurchase(
                Purchase.builder().book(crudService.findBook(3).get())
                        .customer(crudService.findCustomer(1).get())
                        .seller(crudService.findShop(1).get())
                        .count(4).price((int) (1450 * 4 * 0.8 * 1.3)).date(new Date()).build()
        );
        crudService.savePurchase(
                Purchase.builder().book(crudService.findBook(5).get())
                        .customer(crudService.findCustomer(4).get())
                        .seller(crudService.findShop(2).get())
                        .count(2).price(3424).date(new Date()).build()
        );
        crudService.savePurchase(
                Purchase.builder().book(crudService.findBook(1).get())
                        .customer(crudService.findCustomer(4).get())
                        .seller(crudService.findShop(2).get())
                        .count(3).price(2344).date(new Date()).build()
        );
    }
}
