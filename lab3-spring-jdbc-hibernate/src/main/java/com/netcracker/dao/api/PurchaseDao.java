package com.netcracker.dao.api;

import com.netcracker.model.Purchase;

import java.util.List;

public interface PurchaseDao extends CrudDao<Purchase> {
    List<Integer> findUniqueMonth();

}
