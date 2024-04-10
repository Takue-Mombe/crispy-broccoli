package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "courses")
@Getter
@Setter
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseId;
    @Column
    private String courseName;
    @Column
    private String school;
    @Column
    private String department;

    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programmes programme;
    @Column
    private String Lecturer;
    @Column
    private String chairperson;
    @Column
    private String totalStudents;
    @OneToMany(mappedBy = "course")
    private Set<AttendanceRecords> attendanceRecords;

}
