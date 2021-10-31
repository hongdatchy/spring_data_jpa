package com.example.hongdatchy.datajpa.controller;

import com.example.hongdatchy.datajpa.entities.data.*;
import com.example.hongdatchy.datajpa.repo.BaseRepo;
import com.example.hongdatchy.datajpa.service.BangAService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestController {

    BangAService bangAService;

    BaseRepo<BangA> bangABaseRepo;

    BaseRepo<ConA> conABaseRepo;

    BaseRepo<BangB> bangBBaseRepo;

    BaseRepo<Bangtrunggian> bangtrunggianBaseRepo;

    BaseRepo<ChauA> chauABaseRepo;

    @GetMapping("api/bangA")
    public ResponseEntity<Object> findAllA() {
        return ResponseEntity.ok(bangAService.findAllUsingEntityManager());
    }

    @GetMapping("api/bangA/{id}")
    public ResponseEntity<Object> findAllA(@PathVariable int id) {
        return ResponseEntity.ok(bangABaseRepo.findById(id));
    }

    @GetMapping("api/bangAJson")
    public ResponseEntity<Object> findAllAJson() {
        return ResponseEntity.ok(bangAService.findAllJson());
    }

    @GetMapping("api/bangB")
    public ResponseEntity<Object> findAllB() {
        return ResponseEntity.ok(bangBBaseRepo.findAll());
    }

    @GetMapping("api/bangtrunggian")
    public ResponseEntity<Object> findAllBangTrungGian() {
        return ResponseEntity.ok(bangtrunggianBaseRepo.findAll());
    }

    @GetMapping("api/conA")
    public ResponseEntity<Object> findAllConA() {
        return ResponseEntity.ok(conABaseRepo.findAll());
    }

    @GetMapping("api/chauA")
    public ResponseEntity<Object> findAllChauA() {
        return ResponseEntity.ok(chauABaseRepo.findAll());
    }

    @GetMapping("api/bangA/findByNameContains")
    public ResponseEntity<Object> findByNameContains(@RequestParam String str) {
        return ResponseEntity.ok(bangAService.findNameContains(str));
    }

    @DeleteMapping("api/bangA/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        return ResponseEntity.ok(bangABaseRepo.delete(id));
    }

}
