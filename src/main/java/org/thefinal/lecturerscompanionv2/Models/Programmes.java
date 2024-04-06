package org.thefinal.lecturerscompanionv2.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "programmes")@Setter@Getter
public class Programmes {

    @Id
    @Column
    private String programmeId;
    @Column
    private String programmeName;
    @ManyToOne
    private School schools;
    @Column
    private String school;
    @Column
    private String Chairperson;
    @Column
    private String TotalStudents;


}
