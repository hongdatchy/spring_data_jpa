package com.example.hongdatchy.datajpa.entities.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cona")
public class ConA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bangA_id")
    @ToString.Exclude
    private BangA bangA;


    @JsonManagedReference
    @OneToMany(mappedBy = "conA", cascade = CascadeType.ALL)
    private List<ChauA> chauAList;
}
