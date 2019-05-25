package com.netcracker.dao.impl;

import com.netcracker.dao.api.BaseDao;
import com.netcracker.dao.api.ShopDao;
import com.netcracker.model.Book;
import com.netcracker.model.Shop;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Repository("shopDao")
@Transactional
public class ShopDaoImpl extends BaseDao implements ShopDao {

    @Override
    public Optional<Shop> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Shop model) {

    }

    @Override
    public void update(Shop model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Shop> findAll() {
        return null;
    }
}
