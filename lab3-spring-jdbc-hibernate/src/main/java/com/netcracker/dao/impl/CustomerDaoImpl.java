package com.netcracker.dao.impl;

import com.netcracker.dao.api.CustomerDao;
import com.netcracker.model.Customer;
import lombok.Data;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

    @Override
    public List<String> findUniqueDistrict() {
        return getSession().createQuery("SELECT distinct district FROM Customer").list();
    }

    @Override
    public Map<String, Double> findNameAndSaleByDistrict(String district) {
        Map<String, Double> result = new HashMap<>();

        List<Customer> customers =
                getSession().createQuery("FROM Customer WHERE district = :district")
                        .setString("district", district).list();
        customers.forEach(customer -> result.put(customer.getLastName(), customer.getSale()));
        return result;
    }
}
