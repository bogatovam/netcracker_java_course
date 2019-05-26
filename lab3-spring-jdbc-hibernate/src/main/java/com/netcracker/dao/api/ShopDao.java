package com.netcracker.dao.api;

import com.netcracker.model.Shop;

import java.util.List;

public interface ShopDao extends CrudDao<Shop> {
    List<String> findNamesByDistricts(List<String> districts);
}
