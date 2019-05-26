package com.netcracker.dao.impl;

import com.netcracker.dao.api.CrudDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class BaseDao<T> implements CrudDao<T> {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private Class<T> typeOfT;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object object) {
        getSession().persist(object);
    }

    protected void delete(Object object) {
        getSession().delete(object);
    }

    @Override
    public Optional<T> find(Integer id) {
        return Optional.of((T) getSession().get(typeOfT.getName(), id));
    }

    @Override
    public void save(T model) {
        getSession().save(model);
    }

    @Override
    public void update(T model) {
        getSession().update(model);
    }

    @Override
    public void delete(Integer id) {
        Query query = getSession().createQuery("delete from " + typeOfT.getName() + " where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public Long count() {
        return (Long) getSession().createCriteria(typeOfT.getName())
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery("from " + typeOfT.getName()).list();
    }
}
