package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import com.example.hongdatchy.datajpa.entities.jsonToClient.BangAJson;
import com.example.hongdatchy.datajpa.repo.BangACustomRepo;
import com.example.hongdatchy.datajpa.repo.BangARepo;
import com.example.hongdatchy.datajpa.repo.BaseRepo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BangAService_Impl implements BangAService {

    @Autowired
    BangARepo bangARepo;

    @Autowired
    BangACustomRepo bangACustomRepo;

    @Autowired
    BaseService<BangA> bangABaseService;

    @PostConstruct
    public void myPostConstruct(){
        bangABaseService.setClazz(BangA.class);
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
        return bangABaseService.findAll().stream().map(bangA -> {
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
