package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.transaction.PlatformTransactionManager;

@Transactional
public abstract class AbstractHibernateDAO {

    @Autowired
    private EntityManager entityManager;


    protected final Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

}