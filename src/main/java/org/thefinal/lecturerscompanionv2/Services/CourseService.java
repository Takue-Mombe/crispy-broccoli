package org.thefinal.lecturerscompanionv2.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Repositories.CourseRepo;
import org.thefinal.lecturerscompanionv2.Repositories.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepository;
    @Autowired
    private StudentRepo studentRepo;
   // Create
    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Read
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Courses getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    // Update
    public Courses updateCourse(Long courseId, Courses updatedCourse) {
        Courses existingCourse = courseRepository.findById(courseId).orElse(null);
        if (existingCourse != null) {
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setSchool(updatedCourse.getSchool());
            existingCourse.setDepartment(updatedCourse.getDepartment());
            existingCourse.setLecturer(updatedCourse.getLecturer());
            existingCourse.setChairperson(updatedCourse.getChairperson());
            existingCourse.setTotalStudents(updatedCourse.getTotalStudents());
            return courseRepository.save(existingCourse);
        }
        return null; // Or throw an exception
    }

    // Delete
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }



    public List<Students> getStudentsForCourse(String courseId) {
        // Retrieve the course by courseId
        Courses course = courseRepository.findByCourseId(courseId);

        // Check if the course exists
        if (course == null) {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }

        // Retrieve the students enrolled in the course
        return studentRepo.findByProgramme(course.getProgramme());
    }



}
