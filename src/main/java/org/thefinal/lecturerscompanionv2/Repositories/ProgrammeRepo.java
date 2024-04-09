package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thefinal.lecturerscompanionv2.Models.Programmes;


@Repository
public interface ProgrammeRepo extends JpaRepository<Programmes,String> {
}
