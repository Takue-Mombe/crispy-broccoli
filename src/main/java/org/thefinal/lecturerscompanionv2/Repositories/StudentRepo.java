package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thefinal.lecturerscompanionv2.Models.Programmes;
import org.thefinal.lecturerscompanionv2.Models.Students;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Students,String> {

    List<Students> findByProgrammeId(String programId);

    List<Students> findByProgramme(Programmes programme);
}
