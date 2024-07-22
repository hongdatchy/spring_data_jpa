package com.example.hongdatchy.datajpa.entities.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banga")
@Data
public class BangA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;


    @JsonManagedReference
    @OneToMany(mappedBy = "bangA", cascade = CascadeType.ALL)
    private List<ConA> conAList;

    @JsonManagedReference
    @OneToMany(mappedBy = "bangA", cascade = CascadeType.ALL)
    private List<Bangtrunggian> bangtrunggianList;

}
