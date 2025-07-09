package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.model.entities.BangA;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BangAService {

    BangA findNameContains(String str);

    List <BangA> findAllUsingEntityManager();

    int cash(@PathVariable int id,
              @PathVariable int amount);
}
