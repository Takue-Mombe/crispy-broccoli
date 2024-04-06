package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "courses")
@Getter@Setter
public class Courses {
    @Id@Column
    private String CourseId;
    @Column
    private String courseName;
    @Column
    private String school;
    @Column
    private String department;
    @Column
    private String Lecturer;
    @Column
    private String chairperson;
    @Column
    private String totalStudents;


}
