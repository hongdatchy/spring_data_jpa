package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import com.example.hongdatchy.datajpa.entities.jsonToClient.BangAJson;
import com.example.hongdatchy.datajpa.repo.BangACustomRepo;
import com.example.hongdatchy.datajpa.repo.BangARepo;
import com.example.hongdatchy.datajpa.repo.BaseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BangAService_Impl implements BangAService {

    BangARepo bangARepo;

    BangACustomRepo bangACustomRepo;

    BaseRepo<BangA> bangABaseRepo;

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
        return bangABaseRepo.findAll().stream().map(bangA -> BangAJson.builder()
                .id(bangA.getId())
                .name(bangA.getName())
                .bangtrunggianList(bangA.getBangtrunggianList())
                .conAList(bangA.getConAList())
                .additionalField("hello")
                .build()).collect(Collectors.toList());
    }
}
