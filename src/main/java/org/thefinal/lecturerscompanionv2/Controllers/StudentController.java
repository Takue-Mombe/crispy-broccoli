package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Students> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "Front/AdminStudents";
    }
    @PostMapping("/save")
    public String saveStudents(@ModelAttribute Students students) {
        // Process the list of students

            studentService.saveStudent(students);

        return "redirect:/students/list";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("regNumber") String regNumber) {
        studentService.deleteStudent(regNumber);
        return "redirect:/students/list";
    }
}
