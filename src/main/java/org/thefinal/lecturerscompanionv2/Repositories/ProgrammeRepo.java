package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thefinal.lecturerscompanionv2.Models.Programmes;

public interface ProgrammeRepo extends JpaRepository<Programmes,String> {
}
