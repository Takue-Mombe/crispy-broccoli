package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thefinal.lecturerscompanionv2.Models.Attendance;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Students;

import java.util.Optional;

public interface AttendanceRepo extends JpaRepository<Attendance,Long> {
    Optional<Attendance> findByStudentAndCourse(Students student, Courses course);
}
