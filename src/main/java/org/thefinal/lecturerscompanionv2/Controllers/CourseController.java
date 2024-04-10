package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Courses;
import org.thefinal.lecturerscompanionv2.Models.Students;
import org.thefinal.lecturerscompanionv2.Services.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "/Front/AdminCourse";
    }


    @GetMapping("/{courseId}/students")
    @ResponseBody
    public List<Students> getStudentsForCourse(@PathVariable String courseId) {
        // Assuming courseService.getStudentsForCourse(courseId) returns a list of Student objects
        return courseService.getStudentsForCourse(courseId);
    }




    @GetMapping("/all")
    public String getAll(@RequestParam(name = "school", required = false) String selectedSchool, Model model) {
        List<Courses> courses = courseService.getAllCourses();
        courses = courses.stream().distinct().collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("selectedSchool", selectedSchool);
        return "/Front/AdminCourse";
    }

    @GetMapping("/attendanceRecord")
    public String getAttendanceRecord(@RequestParam(name = "school", required = false) String selectedSchool, Model model) {
        List<Courses> courses = courseService.getAllCourses();
        courses = courses.stream().distinct().collect(Collectors.toList());
        model.addAttribute("courses", courses);
        model.addAttribute("selectedSchool", selectedSchool);
        return "/Front/LAttendanceRecord";
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
