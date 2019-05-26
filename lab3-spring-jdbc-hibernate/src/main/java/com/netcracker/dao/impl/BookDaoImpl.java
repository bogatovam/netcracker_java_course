package com.netcracker.dao.impl;

import com.netcracker.dao.api.BookDao;
import com.netcracker.model.Book;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Repository("bookDao")
@Transactional
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    @Override
    public List<String> findUniqueNames() {
        return getSession().createQuery("SELECT distinct name FROM Book").list();
    }

    @Override
    public List<Integer> findUniquePrices() {
        return getSession().createQuery("SELECT distinct price FROM Book").list();
    }

    @Override
    public Map<String, Integer> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price) {
        Map<String, Integer> result = new HashMap<>();

        List<Book> customers =
                getSession().createQuery("FROM Book WHERE price > :price OR  name LIKE '%"+nameTemplate+"%' ORDER BY price DESC")
                        .setInteger("price", price).list();
        customers.forEach(customer -> result.put(customer.getName(), customer.getPrice()));
        return result;
    }
}
