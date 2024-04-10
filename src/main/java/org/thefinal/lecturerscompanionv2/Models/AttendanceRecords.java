package org.thefinal.lecturerscompanionv2.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "attendance")
@Setter
@Getter
public class AttendanceRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Courses course;

    @ManyToMany
    @JoinTable(
            name = "student_attendance",
            joinColumns = @JoinColumn(name = "attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "reg_number")
    )
    private Set<Students> students;
}
