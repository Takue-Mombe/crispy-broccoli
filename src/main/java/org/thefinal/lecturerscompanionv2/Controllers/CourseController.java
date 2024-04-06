package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Services.CourseService;

import java.util.List;

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

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Courses course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/Front/AdminCourse";
        }
        courseService.createCourse(course);
        return "redirect:/courses/list";
    }

}
