package com.netcracker.dao.impl;

import com.netcracker.dao.api.BaseDao;
import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.dao.api.ShopDao;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl extends BaseDao implements PurchaseDao {

    @Override
    public Optional<Purchase> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Purchase model) {

    }

    @Override
    public void update(Purchase model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Purchase> findAll() {
        return null;
    }
}
