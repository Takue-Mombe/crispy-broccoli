package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thefinal.lecturerscompanionv2.Models.Lecturers;

public interface LecturerRepo extends JpaRepository<Lecturers,String> {
}
