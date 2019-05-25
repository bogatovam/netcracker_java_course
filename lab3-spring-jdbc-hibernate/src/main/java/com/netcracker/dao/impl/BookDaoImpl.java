package com.netcracker.dao.impl;

import com.netcracker.dao.api.BaseDao;
import com.netcracker.dao.api.BookDao;
import com.netcracker.dao.api.CustomerDao;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import lombok.Data;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Repository("bookDao")
@Transactional
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public Optional<Book> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Book model) {

    }

    @Override
    public void update(Book model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
