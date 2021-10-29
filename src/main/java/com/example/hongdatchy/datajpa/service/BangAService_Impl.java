package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import com.example.hongdatchy.datajpa.entities.jsonToClient.BangAJson;
import com.example.hongdatchy.datajpa.repo.BangACustomRepo;
import com.example.hongdatchy.datajpa.repo.BangARepo;
import com.example.hongdatchy.datajpa.repo.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BangAService_Impl implements BangAService {

    @Autowired
    BangARepo bangARepo;

    @Autowired
    BangACustomRepo bangACustomRepo;

    @Autowired
    BaseRepo<BangA> bangABaseRepo;

    @PostConstruct
    public void myPostConstruct(){
        bangABaseRepo.setClazz(BangA.class);
    }

    @Override
    public BangA findNameContains(String str) {
        return bangARepo.findBangAByNameContains(str);
    }

    @Override
    public List<BangA> findAllUsingEntityManager() {
        return bangACustomRepo.findAllUsingEntityManager();
    }

    @Override
    public List<BangAJson> findAllJson() {
        return bangABaseRepo.findAll().stream().map(bangA -> {
            return  BangAJson.builder()
                    .id(bangA.getId())
                    .name(bangA.getName())
                    .bangtrunggianList(bangA.getBangtrunggianList())
                    .conAList(bangA.getConAList())
                    .additionalField("hello")
                    .build();
        }).collect(Collectors.toList());
    }
}
