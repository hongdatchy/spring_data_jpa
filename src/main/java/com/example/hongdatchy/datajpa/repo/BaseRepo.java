package com.example.hongdatchy.datajpa.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseRepo<T> {

    void setClazz(Class< T > clazzToSet);

    T createAndUpdate(T t);

    boolean delete(int id);

    List<T> findAll();

    T findById(int id);
}
