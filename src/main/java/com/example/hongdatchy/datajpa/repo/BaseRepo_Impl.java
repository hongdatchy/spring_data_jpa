package com.example.hongdatchy.datajpa.repo;

//import io.swagger.annotations.Scope;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class BaseRepo_Impl<T> implements BaseRepo<T>{

    private Class<T> clazz;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public T createAndUpdate(T t) {
        return entityManager.merge(t);
    }

    @Override
    public boolean delete(int id) {
        T t = findById(id);
        if(t != null){
            entityManager.remove(t);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public T findById(int id){
        return entityManager.find(clazz, id);
    }
}
