package com.netcracker.dao.impl;

import com.netcracker.dao.api.CustomerDao;
import com.netcracker.model.Customer;
import javafx.util.Pair;
import lombok.Data;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Data
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

    @Override
    public List<String> findUniqueDistrict() {
        return getSession().createQuery("SELECT distinct district FROM Customer").list();
    }

    @Override
    public List<Pair<String, Double>> findNameAndSaleByDistrict(String district) {
        List<Pair<String, Double>> result = new ArrayList<>();

        List<Customer> customers =
                getSession().createQuery("FROM Customer WHERE district = :district")
                        .setString("district", district).list();
        customers.forEach(customer -> result.add(
                new Pair<>(customer.getLastName(), customer.getSale())));
        return result;
    }
}
