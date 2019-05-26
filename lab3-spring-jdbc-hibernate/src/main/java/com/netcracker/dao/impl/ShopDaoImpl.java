package com.netcracker.dao.impl;

import com.netcracker.dao.api.ShopDao;
import com.netcracker.model.Shop;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Repository("shopDao")
@Transactional
public class ShopDaoImpl extends BaseDao<Shop> implements ShopDao {
    public List<String> findNamesByDistricts(List<String> districts) {
        List<String> result = new ArrayList<>();
        List<Shop> shops = getSession().createQuery("FROM Shop").list();
        shops.stream().filter(shop -> districts.contains(shop.getDistrict()))
                .forEach(shop -> result.add(shop.getName()));
        return result;
    }
}
