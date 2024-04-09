package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "courses")
@Getter@Setter
public class Courses {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String courseId;
    @Column
    private String courseName;
    @Column
    private String school;
    @Column
    private String department;
    @Column
    private String programmeId;
    @Column
    private String Lecturer;
    @Column
    private String chairperson;
    @Column
    private String totalStudents;


}
