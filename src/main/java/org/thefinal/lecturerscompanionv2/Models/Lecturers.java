package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "lecturers")@Setter@Getter
public class Lecturers {

    @Id@Column
    private String lecturerNumber;
    @Column
    private String lName; @Column
    private String email; @Column
    private String phone; @Column
    private String address; @Column
    private String hireDate; @Column
    private String highestDegree; @Column
    private String courses;
    @Column
    private String totalStudents;
}
