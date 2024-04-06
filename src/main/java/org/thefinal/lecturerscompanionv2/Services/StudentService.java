package org.thefinal.lecturerscompanionv2.Services;


import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Repositories.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public Students saveStudent(Students students){
        return studentRepo.save(students);
    }
    // Read
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }
    public Students getStudentById(String regNumber) {
        return studentRepo.findById(regNumber).orElse(null);
    }
    // Update
    public Students updateStudent(String regNumber, Students updatedStudent) {
        Students existingStudent = studentRepo.findById(regNumber).orElse(null);
        if (existingStudent != null) {
            existingStudent.setYearEnrolled(updatedStudent.getYearEnrolled());
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setProgramme(updatedStudent.getProgramme());
            existingStudent.setPhone(updatedStudent.getPhone());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setNextOfKin(updatedStudent.getNextOfKin());
            existingStudent.setNextOfKinPhone(updatedStudent.getNextOfKinPhone());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepo.save(existingStudent);
        }
        return null; // Or throw an exception
    }
    // Delete
    public void deleteStudent(String regNumber) {
        studentRepo.deleteById(regNumber);
    }
}
