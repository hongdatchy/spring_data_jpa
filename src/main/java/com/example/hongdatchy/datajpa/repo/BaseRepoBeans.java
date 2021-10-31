package com.example.hongdatchy.datajpa.repo;

import com.example.hongdatchy.datajpa.entities.data.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
public class BaseRepoBeans {

    @Bean
    public BaseRepo_Impl<BangA> bangABaseRepo_() {
        return new BaseRepo_Impl<>();
    }

    @Bean
    public BaseRepo_Impl<BangB> bangBBaseRepo_() {
        return new BaseRepo_Impl<>();
    }

    @Bean
    public BaseRepo_Impl<ConA> conABaseRepo() {
        return new BaseRepo_Impl<>();
    }

    @Bean
    public BaseRepo_Impl<ChauA> chauABaseRepo() {
        return new BaseRepo_Impl<>();
    }

    @Bean
    public BaseRepo_Impl<Bangtrunggian> bangtrunggianBaseRepo() {
        return new BaseRepo_Impl<>();
    }

    @Component
    @AllArgsConstructor
    public static class SetClassForRepo {

        BaseRepo<BangA> bangABaseRepo;

        BaseRepo<ConA> conABaseRepo;

        BaseRepo<BangB> bangBBaseRepo;

        BaseRepo<Bangtrunggian> bangtrunggianBaseRepo;

        BaseRepo<ChauA> chauABaseRepo;

        @PostConstruct
        public void postConstruct() {
            bangABaseRepo.setClazz(BangA.class);
            bangBBaseRepo.setClazz(BangB.class);
            bangtrunggianBaseRepo.setClazz(Bangtrunggian.class);
            conABaseRepo.setClazz(ConA.class);
            chauABaseRepo.setClazz(ChauA.class);
        }
    }
}
