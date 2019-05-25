package com.netcracker.dao.impl;

import com.netcracker.dao.api.BaseDao;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.model.Customer;
import lombok.Data;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public List<String> findAllByLastName(String lastName) {
        Query query = getSession().createQuery("select district from Customer");
        return (List<String>)query.list();
    }

    @Override
    public Optional<Customer> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer model) {

    }

    @Override
    public void update(Customer model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
