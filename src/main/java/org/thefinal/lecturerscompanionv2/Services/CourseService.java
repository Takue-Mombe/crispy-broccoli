package org.thefinal.lecturerscompanionv2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Repositories.CourseRepo;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepository;

    // Create
    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Read
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Courses getCourseById(String courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    // Update
    public Courses updateCourse(String courseId, Courses updatedCourse) {
        Courses existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse != null) {
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setSchool(updatedCourse.getSchool());
            existingCourse.setDepartment(updatedCourse.getDepartment());
            existingCourse.setProgramme(updatedCourse.getProgramme());
            existingCourse.setLecturer(updatedCourse.getLecturer());
            existingCourse.setChairperson(updatedCourse.getChairperson());
            existingCourse.setTotalStudents(updatedCourse.getTotalStudents());
            return courseRepository.save(existingCourse);
        }
        return null; // Or throw an exception
    }

    // Delete
    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }
}
