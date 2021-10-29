package com.example.hongdatchy.datajpa.entities.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bangtrunggian")
public class Bangtrunggian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "bangA_id", nullable = false)
//    private Integer bangaId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bangA_id")
    private BangA bangA;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bangB_id")
    private BangB bangB;
//    @Column(name = "bangB_id", nullable = false)
//    private Integer bangbId;

    @Column(name = "name", nullable = false)
    private String name;

}
