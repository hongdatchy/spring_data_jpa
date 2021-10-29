package com.example.hongdatchy.datajpa.service;

import java.util.List;

public interface BaseService<T> {

    void setClazz(Class< T > clazzToSet);

    T createAndUpdate(T t);

    boolean delete(int id);

    List<T> findAll();

    T findById(int id);

}
