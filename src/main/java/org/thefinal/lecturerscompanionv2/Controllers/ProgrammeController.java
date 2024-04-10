package org.thefinal.lecturerscompanionv2.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Programmes;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Repositories.StudentRepo;
import org.thefinal.lecturerscompanionv2.Services.ProgrammeService;
import org.thefinal.lecturerscompanionv2.Services.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/programmes")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listProgrammes(Model model) {
        List<Programmes> programmes = programmeService.getAllProgrammes();
        model.addAttribute("programmes", programmes);
        return "Front/AdminProgrammes";
    }
    @GetMapping("/students")
    public Map<String, Object> getStudentsByProgramId(@RequestParam("programId") String programId) {
        Map<String, Object> response = new HashMap<>();

        List<Students> students = studentService.getStudentsByProgramId(programId);
        int totalCount = students.size(); // Assuming the size of the list represents the total count

        response.put("students", students);
        response.put("totalCount", totalCount);
        System.out.println(totalCount);
        return response;
    }
    @PostMapping("/save")
    public String saveProgrammes(@ModelAttribute Programmes programmes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Front/AdminProgrammes"; // Or any error handling logic you need
        }

            programmeService.createProgramme(programmes); // Assuming programmeService is injected and has a method createProgramme}

        return "Front/AdminProgrammes";
    }
    @GetMapping("/delete")
    public String deleteProgramme(@RequestParam("programmeId") String programmeId) {
        programmeService.deleteProgramme(programmeId);
        return "redirect:/programmes/list";
    }
}
