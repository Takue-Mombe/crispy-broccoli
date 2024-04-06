package org.thefinal.lecturerscompanionv2.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.School;
import org.thefinal.lecturerscompanionv2.Repositories.SchoolRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepo schoolRepository;

    // Create operation
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    // Read operation
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(String schoolId) {
        return schoolRepository.findById(schoolId);
    }

    // Update operation
    public School updateSchool(String schoolId, School updatedSchool) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (schoolOptional.isPresent()) {
            School existingSchool = schoolOptional.get();
            existingSchool.setSchoolName(updatedSchool.getSchoolName());
            existingSchool.setProgramme(updatedSchool.getProgramme());
            existingSchool.setProgrammes(updatedSchool.getProgrammes());
            return schoolRepository.save(existingSchool);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    // Delete operation
    public void deleteSchool(String schoolId) {
        schoolRepository.deleteById(schoolId);
    }
}
