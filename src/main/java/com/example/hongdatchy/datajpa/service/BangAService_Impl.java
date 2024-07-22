package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.entities.data.BangA;
import com.example.hongdatchy.datajpa.repo.BangACustomRepo;
import com.example.hongdatchy.datajpa.repo.BangARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BangAService_Impl implements BangAService {

    BangARepository bangARepository;

    BangACustomRepo bangACustomRepo;


    @Override
    public BangA findNameContains(String str) {
        return bangARepository.findBangAByNameContains(str);
    }

    @Override
    public List<BangA> findAllUsingEntityManager() {
        return bangACustomRepo.findAllUsingEntityManager();
    }

}
