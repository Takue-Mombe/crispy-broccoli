package org.thefinal.lecturerscompanionv2.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "programmes")@Setter@Getter
public class Programmes {

    @Id
    @Column(name = "programme_id")
    private String programmeId;
    @Column
    private String programmeName;
    @Column
    private String school;
    @Column
    private String Chairperson;
    @Column
    private String TotalStudents;
    @OneToMany(mappedBy = "programme")
    private Set<Students> students;


}
