package org.thefinal.lecturerscompanionv2.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.Lecturers;
import org.thefinal.lecturerscompanionv2.Repositories.LecturerRepo;

import java.util.List;

@Service
public class LecturersService {
    @Autowired
    private LecturerRepo lecturerRepository;

    // Create
    public Lecturers createLecturer(Lecturers lecturer) {
        return lecturerRepository.save(lecturer);
    }

    // Read
    public List<Lecturers> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public Lecturers getLecturerByNumber(Long  id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    // Update
    public Lecturers updateLecturer(Long id, Lecturers updatedLecturer) {
        Lecturers existingLecturer = lecturerRepository.findById(id).orElse(null);
        if (existingLecturer != null) {
            existingLecturer.setLName(updatedLecturer.getLName());
            existingLecturer.setEmail(updatedLecturer.getEmail());
            existingLecturer.setPhone(updatedLecturer.getPhone());
            existingLecturer.setAddress(updatedLecturer.getAddress());
            existingLecturer.setHireDate(updatedLecturer.getHireDate());
            existingLecturer.setHighestDegree(updatedLecturer.getHighestDegree());
            existingLecturer.setCourses(updatedLecturer.getCourses());
            existingLecturer.setTotalStudents(updatedLecturer.getTotalStudents());
            return lecturerRepository.save(existingLecturer);
        }
        return null; // Or throw an exception
    }
    // Delete
    public void deleteLecturer(Long id) {
        lecturerRepository.deleteById(id);
    }
    public Long lecturerCount(){
        return lecturerRepository.count();
    }
}
