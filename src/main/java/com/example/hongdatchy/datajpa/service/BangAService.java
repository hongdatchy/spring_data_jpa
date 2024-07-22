package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import com.example.hongdatchy.datajpa.entities.response.BangAJson;

import java.util.List;

public interface BangAService {

    BangA findNameContains(String str);

    List <BangA> findAllUsingEntityManager();
}
