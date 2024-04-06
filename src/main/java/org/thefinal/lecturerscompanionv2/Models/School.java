package org.thefinal.lecturerscompanionv2.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "school")@Getter@Setter
public class School {
    @Id@Column
    private String schoolId;
    @Column
    private String schoolName;
    @ManyToOne
    private Programmes programme;
    @Column
    private String programmes;

}
