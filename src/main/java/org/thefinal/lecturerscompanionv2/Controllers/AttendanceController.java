package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Attendance;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Repositories.AttendanceRepo;
import org.thefinal.lecturerscompanionv2.Repositories.CourseRepo;
import org.thefinal.lecturerscompanionv2.Repositories.StudentRepo;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    private final AttendanceRepo attendanceRepository;
    private final StudentRepo studentsRepository;
    private final CourseRepo coursesRepository;

    @Autowired
    public AttendanceController(AttendanceRepo attendanceRepository, StudentRepo studentsRepository, CourseRepo coursesRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentsRepository = studentsRepository;
        this.coursesRepository = coursesRepository;
    }

    @PostMapping("/attendance")
    public ResponseEntity<String> addAttendance(@RequestParam String studentId, @RequestParam Long courseId) {
        Optional<Students> studentOptional = studentsRepository.findById(studentId);
        Optional<Courses> courseOptional = coursesRepository.findById(courseId);

        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Students student = studentOptional.get();
            Courses course = courseOptional.get();

            // Check if the attendance entry already exists for the student and course
            Optional<Attendance> existingAttendance = attendanceRepository.findByStudentAndCourse(student, course);
            if (existingAttendance.isPresent()) {
                // If attendance already exists, increment the count
                Attendance attendance = existingAttendance.get();
                attendance.setCount(attendance.getCount() + 1);
                attendanceRepository.save(attendance);
            } else {
                // If attendance doesn't exist, create a new entry
                Attendance attendance = new Attendance();
                attendance.setStudent(student);
                attendance.setCourse(course);
                attendance.setDateTime(LocalDateTime.now());
                attendance.setCount(1); // Initial count is 1
                attendanceRepository.save(attendance);
            }
            return ResponseEntity.ok("Attendance added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student or Course not found.");
        }
    }

}
