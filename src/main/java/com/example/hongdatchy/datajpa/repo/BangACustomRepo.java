package com.example.hongdatchy.datajpa.repo;


import com.example.hongdatchy.datajpa.model.entities.BangA;

import java.util.List;

public interface BangACustomRepo {
    List<BangA> findAllUsingEntityManager();
}
