package com.example.hongdatchy.datajpa.service;

import com.example.hongdatchy.datajpa.model.entities.BangA;
import com.example.hongdatchy.datajpa.repo.BangACustomRepo;
import com.example.hongdatchy.datajpa.repo.BangARepository;
import com.example.hongdatchy.datajpa.repo.BangBRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BangAService_Impl implements BangAService {

    BangARepository bangARepository;

    BangBRepository bangBRepository;

    BangACustomRepo bangACustomRepo;


    @Override
    public BangA findNameContains(String str) {
        return bangARepository.findBangAByNameContains(str);
    }

    @Override
    public List<BangA> findAllUsingEntityManager() {
        return bangACustomRepo.findAllUsingEntityManager();
    }

    @Transactional
    public int cash(int id, int amount) {
        BangA bangA = bangARepository.findByIdForUpdate(id).orElse(null);
        if (amount > 0 && amount > bangA.getAmount()) {
            throw new RuntimeException("Không đủ tiền");
        }
        bangA.setAmount(bangA.getAmount() - amount);
        bangARepository.save(bangA);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }



}
