package com.example.hongdatchy.datajpa.repo;


import com.example.hongdatchy.datajpa.entities.data.BangA;

import java.util.List;

public interface BangACustomRepo {
    List<BangA> findAllUsingEntityManager();
}
