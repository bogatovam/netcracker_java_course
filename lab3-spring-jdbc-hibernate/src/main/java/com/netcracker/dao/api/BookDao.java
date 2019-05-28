package com.netcracker.dao.api;

import com.netcracker.model.Book;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface BookDao extends CrudDao<Book> {
    List<String> findUniqueNames();
    List<Integer> findUniquePrices();

    List<Pair<String, Integer>> findNameAndPriceByNameAndPrice(String nameTemplate, Integer price);

}
