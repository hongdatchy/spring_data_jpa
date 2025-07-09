package com.example.hongdatchy.datajpa.repo;

import com.example.hongdatchy.datajpa.model.entities.BangA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface BangARepository extends JpaRepository<BangA, Integer> {
    BangA findBangAByNameContains(String str);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM BangA b WHERE b.id = :id")
    Optional<BangA> findByIdForUpdate(int id);
}
