package com.netcracker.dao.api;

import com.netcracker.model.Book;

import java.util.List;
import java.util.Map;

public interface BookDao extends CrudDao<Book> {
    List<String> findUniqueNames();
    List<Integer> findUniquePrices();

    Map<String, Integer> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price);

}
