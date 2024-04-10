package org.thefinal.lecturerscompanionv2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thefinal.lecturerscompanionv2.Models.Courses;

public interface CourseRepo extends JpaRepository<Courses,Long> {
    Courses findByCourseId(String courseId);
}
