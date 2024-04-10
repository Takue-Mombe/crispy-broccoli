package org.thefinal.lecturerscompanionv2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Repositories.CourseRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public List<String> getStudentNamesForCourse(String courseId) {
        List<String> studentNames = new ArrayList<>();
        Courses course = courseRepository.findByCourseId(courseId);
        if (course != null) {
            Set<Students> students = course.getProgramme().getStudents();
            for (Students student : students) {
                studentNames.add(student.getFirstname() + " " + student.getLastname());
            }
        }
        return studentNames;
    }
}
