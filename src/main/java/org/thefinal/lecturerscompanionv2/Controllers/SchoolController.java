package org.thefinal.lecturerscompanionv2.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.School;
import org.thefinal.lecturerscompanionv2.Services.SchoolService;

import java.util.List;

@Controller
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    // Display all schools
    @GetMapping("/list")
    public String listSchools(Model model) {
        List<School> schools = schoolService.getAllSchools();
        model.addAttribute("schools", schools);
        return "/Front/AdminCourse"; // Assuming you have a Thymeleaf template named "list.html" in the "school" directory
    }
    @PostMapping("/add")
    public String addSchool(@RequestBody School school, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/Front/AdminCourse";
        }
        schoolService.createSchool(school);
        return "redirect:/schools/list";
    }
    @GetMapping("/delete/{schoolId}")
    public String deleteSchool(@PathVariable("schoolId") String schoolId) {
        schoolService.deleteSchool(schoolId);
        return "redirect:/schools/list";
    }

}
