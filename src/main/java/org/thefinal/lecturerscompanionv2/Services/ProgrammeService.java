package org.thefinal.lecturerscompanionv2.Services;

import org.springframework.stereotype.Service;
import org.thefinal.lecturerscompanionv2.Models.Programmes;
import org.thefinal.lecturerscompanionv2.Repositories.ProgrammeRepo;

import java.util.List;

@Service
public class ProgrammeService {
    private final ProgrammeRepo programmeRepository;

    public ProgrammeService(ProgrammeRepo programmeRepository) {
        this.programmeRepository = programmeRepository;
    }

    // Create
    public void createProgramme(Programmes programme) {
        programmeRepository.save(programme);
    }

    // Read
    public List<Programmes> getAllProgrammes() {
        return programmeRepository.findAll();
    }

    public Programmes getProgrammeById(String programmeId) {
        return programmeRepository.findById(programmeId).orElse(null);
    }

    // Update
    public Programmes updateProgramme(String programmeId, Programmes updatedProgramme) {
        Programmes existingProgramme = programmeRepository.findById(programmeId).orElse(null);
        if (existingProgramme != null) {
            existingProgramme.setProgrammeName(updatedProgramme.getProgrammeName());
            existingProgramme.setSchool(updatedProgramme.getSchool());
            existingProgramme.setChairperson(updatedProgramme.getChairperson());
            existingProgramme.setTotalStudents(updatedProgramme.getTotalStudents());
            return programmeRepository.save(existingProgramme);
        }
        return null; // Or throw an exception
    }

    // Delete
    public void deleteProgramme(String programmeId) {
        programmeRepository.deleteById(programmeId);
    }

    //count
    public Long programmeCount(){
     return programmeRepository.count();
    }
}
