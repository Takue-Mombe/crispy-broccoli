package org.thefinal.lecturerscompanionv2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "students")
@Getter@Setter
public class Students {
    @Id@Column
    private String regNumber;
    @Column
    private String yearEnrolled;
    @Column
    private String firstname;
    @Column
    private String lastname; @Column
    private String programme; @Column
    private String phone; @Column
    private String email; @Column
    private String nextOfKin; @Column
    private String nextOfKinPhone; @Column
    private String address;

}
