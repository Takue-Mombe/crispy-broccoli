package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thefinal.lecturerscompanionv2.Models.Students;

public interface StudentRepo extends JpaRepository<Students,String> {
}
