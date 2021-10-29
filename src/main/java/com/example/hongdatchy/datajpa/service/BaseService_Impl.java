package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.repo.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService_Impl<T> implements BaseService<T>{

    @Autowired
    BaseRepo<T> baseRepo;

    @Override
    public void setClazz(Class<T> clazzToSet) {
        baseRepo.setClazz(clazzToSet);
    }

    @Override
    public T createAndUpdate(T t) {
        return baseRepo.createAndUpdate(t);
    }

    @Override
    public boolean delete(int id) {
        return baseRepo.delete(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepo.findAll();
    }

    @Override
    public T findById(int id) {
        return baseRepo.findById(id);
    }
}
