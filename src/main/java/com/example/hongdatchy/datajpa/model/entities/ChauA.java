package com.example.hongdatchy.datajpa.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "chaua")
@Data
public class ChauA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "conA_id")
    @ToString.Exclude
    private ConA conA;

    @Column(name = "name", nullable = false)
    private String name;

}
