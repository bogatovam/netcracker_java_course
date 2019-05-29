package com.netcracker.service.impl;

import com.netcracker.dao.api.BookDao;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.dao.api.ShopDao;
import com.netcracker.model.Shop;
import com.netcracker.service.api.DisplayDataService;
import javafx.util.Pair;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Service("dataService")
@RequiredArgsConstructor
public class DisplayDataServiceImpl implements DisplayDataService {
    @Autowired
    BookDao bookDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    ShopDao shopDao;

    @Override
    public List<String> findUniqueBookNames() {
        return bookDao.findUniqueNames();
    }

    @Override
    public List<Integer> findUniqueBookPrices() {
        return bookDao.findUniquePrices();
    }

    @Override
    public List<Integer> findUniquePurchaseMonth() {
        return purchaseDao.findUniqueMonth();
    }

    @Override
    public List<String> findUniqueCustomerDistrict() {
        return customerDao.findUniqueDistrict();
    }

    @Override
    public List<Pair<String, Double>> findNameAndSaleByDistrict(String district) {
        return customerDao.findNameAndSaleByDistrict(district);
    }

    @Override
    public List<String> findNamesByDistricts(List<String> districts) {
        return shopDao.findNamesByDistricts(districts);
    }

    @Override
    public List<Pair<String, Integer>> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price) {
        return bookDao.findNameAndPriceByNameAndPrice(nameTemplate, price);
    }

    @Override
    public List<Pair<String, String>> findCustomersAndShopsNames() {
        return purchaseDao.findCustomersAndShopsNames();
    }

    @Override
    public String getAllDateLastNameSaleNameCount() {
        StringBuilder result = new StringBuilder();
        purchaseDao.findAll().forEach(purchase ->
                result.append(purchase.getDate() + " , " +
                        purchase.getCustomer().getLastName() + " , " +
                        purchase.getCustomer().getSale() + " , " +
                        purchase.getBook().getName() + " , " +
                        purchase.getCount())
        );
        return result.toString();
    }

    @Override
    public Map<Integer, Pair<String, Date>> findIdLastNameDateByPrice(Integer price) {
        return purchaseDao.findIdLastNameDateByPrice(price);
    }

    @Override
    public List<String> findLastNameDistrictDateByMonth(Integer month){
        return purchaseDao.findLastNameDistrictDateByMonth(month);
    }

    @Override
    public List<Shop> findShopsByDistrictAndSale() {
        return purchaseDao.findShopsByDistrictAndSale();
    }

    @Override
    public List<String> findPurchaseByBooksStorageAndCount() {
        return purchaseDao.findPurchaseByBooksStorageAndCount();
    }
}
