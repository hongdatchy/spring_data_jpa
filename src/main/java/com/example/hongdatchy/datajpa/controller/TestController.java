package com.example.hongdatchy.datajpa.controller;

import com.example.hongdatchy.datajpa.entities.data.*;
import com.example.hongdatchy.datajpa.service.BangAService;
import com.example.hongdatchy.datajpa.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@RestController
public class TestController {

     BangAService bangAService;

     BaseService<BangA> bangABaseService;

     BaseService<ConA> conABaseService;

     BaseService<BangB> bangBBaseService;

     BaseService<Bangtrunggian> bangtrunggianBaseService;

     BaseService<ChauA> chauABaseService;

    @PostConstruct
    public void setClassForRepo() {
        /*
        postcontruct chỉ làm được 1 cái, nếu nhiều sẽ gây ra lỗi --> phải set ở các controller như phía dưới
        nếu mà làm thực tế thì ta sẽ khó có thể gặp trường hợp để các baseservice trong 1 controller như thế
        này nên ta không cần quá lo lắng
        */
        bangABaseService.setClazz(BangA.class);
    }

    @GetMapping("api/bangA")
    public ResponseEntity<Object> findAllA() {
        return ResponseEntity.ok(bangAService.findAllUsingEntityManager());
    }

    @GetMapping("api/bangA/{id}")
    public ResponseEntity<Object> findAllA(@PathVariable int id) {
        return ResponseEntity.ok(bangABaseService.findById(id));
    }

    @GetMapping("api/bangAJson")
    public ResponseEntity<Object> findAllAJson() {
        return ResponseEntity.ok(bangAService.findAllJson());
    }

    @GetMapping("api/bangB")
    public ResponseEntity<Object> findAllB() {
        bangBBaseService.setClazz(BangB.class);
        return ResponseEntity.ok(bangBBaseService.findAll());
    }

    @GetMapping("api/bangtrunggian")
    public ResponseEntity<Object> findAllBangTrungGian() {
        bangtrunggianBaseService.setClazz(Bangtrunggian.class);
        return ResponseEntity.ok(bangtrunggianBaseService.findAll());
    }

    @GetMapping("api/conA")
    public ResponseEntity<Object> findAllConA() {
        conABaseService.setClazz(ConA.class);
        return ResponseEntity.ok(conABaseService.findAll());
    }

    @GetMapping("api/chauA")
    public ResponseEntity<Object> findAllChauA() {
        chauABaseService.setClazz(ChauA.class);
        return ResponseEntity.ok(chauABaseService.findAll());
    }

    @PostMapping("api/bangA/findByNameContains")
    public ResponseEntity<Object> findByNameContains(@RequestBody String str) {
        return ResponseEntity.ok(bangAService.findNameContains(str));
    }

    @DeleteMapping("api/bangA/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        return ResponseEntity.ok(bangABaseService.delete(id));
    }

}
