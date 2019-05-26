package com.netcracker.service.impl;

import com.netcracker.dao.api.BookDao;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.dao.api.ShopDao;
import com.netcracker.service.api.DisplayUniqueDataService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Data
@Service("task2Service")
@RequiredArgsConstructor
public class DisplayUniqueDataServiceImpl implements DisplayUniqueDataService {
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
    public Map<String, Double> findNameAndSaleByDistrict(String district) {
        return customerDao.findNameAndSaleByDistrict(district);
    }

    @Override
    public List<String> findNamesByDistricts(List<String> districts) {
        return shopDao.findNamesByDistricts(districts);
    }

    @Override
    public Map<String, Integer> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price) {
        return bookDao.findNameAndPriceByNameAndPrice(nameTemplate, price);
    }
}
