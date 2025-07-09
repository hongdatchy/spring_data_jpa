package com.example.hongdatchy.datajpa.repo;

import com.example.hongdatchy.datajpa.model.entities.BangA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BangACustomRepo_Impl implements BangACustomRepo{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<BangA> findAllUsingEntityManager() {
        return entityManager.createQuery("select x from BangA x").getResultList();
    }
}
