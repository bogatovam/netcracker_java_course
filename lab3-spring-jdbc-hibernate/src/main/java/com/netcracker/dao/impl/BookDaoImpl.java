package com.netcracker.dao.impl;

import com.netcracker.dao.api.BookDao;
import com.netcracker.model.Book;
import javafx.util.Pair;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public  List<Pair<String, Integer>> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price) {
        List<Pair<String, Integer>>  result = new ArrayList<>();

        List<Book> customers =
                getSession().createQuery("FROM Book WHERE price > :price OR  name LIKE '%"+nameTemplate+"%' ORDER BY price DESC")
                        .setInteger("price", price).list();
        customers.forEach(customer -> result.add(
                new Pair<>(customer.getName(), customer.getPrice())));
        return result;
    }
}
