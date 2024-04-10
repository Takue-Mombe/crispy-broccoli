package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Programmes;
import org.thefinal.lecturerscompanionv2.Services.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "/Front/AdminCourse";
    }
    @GetMapping("/{courseId}")
    public String showCourse(@PathVariable String courseId, Model model) {
        List<String> studentNames = courseService.getStudentNamesForCourse(courseId);
        model.addAttribute("students", studentNames);
        return "/Front/LAttendanceRecord"; // Name of your Thymeleaf template
    }
    @GetMapping("/all")
    public String getAll(@RequestParam(name = "school", required = false) String selectedSchool, Model model) {
        List<Courses> courses = courseService.getAllCourses();// Assuming your service method returns List<Model>
        courses=courses.stream().distinct().collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("selectedSchool", selectedSchool);
        courseService.getAllCourses();
        return "/Front/AdminCourse"; // Assuming "dropdown" is the name of your Thymeleaf template
    }
    @PostMapping("/save")
    public String saveProgrammes(@ModelAttribute Courses coursesList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Front/AdminCourse";
        }
            courseService.createCourse(coursesList);

        return "Front/AdminCourse";
    }


}
