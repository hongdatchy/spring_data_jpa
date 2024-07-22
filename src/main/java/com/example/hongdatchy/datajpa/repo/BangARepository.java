package com.example.hongdatchy.datajpa.repo;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangARepository extends JpaRepository<BangA, Integer> {
    BangA findBangAByNameContains(String str);
}
