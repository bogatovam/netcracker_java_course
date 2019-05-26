package com.netcracker.dao.impl;

import com.netcracker.dao.api.PurchaseDao;
import com.netcracker.model.Purchase;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl extends BaseDao<Purchase> implements PurchaseDao {

    @Override
    public List<Integer> findUniqueMonth() {
        List<Integer> result = new ArrayList<>();
        List<Date> dates = getSession().createQuery("SELECT distinct date FROM Purchase").list();

        dates.forEach(date -> result.add(date.getMonth()));
        return result;
    }
}
