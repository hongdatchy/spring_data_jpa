package com.example.hongdatchy.datajpa.repo;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangARepo extends CrudRepository<BangA, Integer> {
    BangA findBangAByNameContains(String str);
}
