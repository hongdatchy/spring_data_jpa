package com.example.hongdatchy.datajpa.entities.response;

import com.example.hongdatchy.datajpa.entities.data.Bangtrunggian;
import com.example.hongdatchy.datajpa.entities.data.ConA;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BangAJson {

    private Integer id;

    private String name;

    private List<ConA> conAList;

    private List<Bangtrunggian> bangtrunggianList;

    private String additionalField;

}
