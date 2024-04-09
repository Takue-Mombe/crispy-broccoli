package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "students")
@Getter@Setter
public class Students {
    @Id@Column
    private String regNumber;
    @Column
    private String yearEnrolled;
    @Column
    private String firstname;
    private String programmeId;
    @Column
    private String lastname; @Column
    private String phone; @Column
    private String email; @Column
    private String nextOfKin; @Column
    private String nextOfKinPhone; @Column
    private String address;

}
