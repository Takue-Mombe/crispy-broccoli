package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "lecturers")@Setter@Getter
public class Lecturers {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String lecturerNumber;
    @Column
    public String fName;
    @Column
    public String lName; @Column
    public String email;
    @Column
    public String hitMail; @Column
    public String phone; @Column
    public String address; @Column

    public String department; @Column
    public String hireDate; @Column
    public String highestDegree; @Column
    public String courses;
    @Column
    public String totalStudents;
}
