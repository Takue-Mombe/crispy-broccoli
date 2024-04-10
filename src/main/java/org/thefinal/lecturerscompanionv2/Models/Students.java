package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "students")
@Getter@Setter
public class Students {
    @Id @Column(name = "reg_number")
    private String regNumber;
    @Column
    private String yearEnrolled;
    @Column
    private String firstname;
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programmes programme;


    @Column
    private String lastname; @Column
    private String phone; @Column
    private String email; @Column
    private String nextOfKin; @Column
    private String nextOfKinPhone; @Column
    private String address;

}
