package org.thefinal.lecturerscompanionv2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thefinal.lecturerscompanionv2.Models.Lecturers;
import org.thefinal.lecturerscompanionv2.Services.LecturersService;

import java.util.List;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    private LecturersService lecturerService;

    @GetMapping("/list")
    public String listLecturers(Model model) {
        List<Lecturers> lecturers = lecturerService.getAllLecturers();
        model.addAttribute("lecturers", lecturers);
        return "Front/AdminLecturer";
    }
    @PostMapping("/save")
    public String saveLecturer(@ModelAttribute("lecturer") Lecturers lecturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Front/AdminLecturer";
        }
        lecturerService.createLecturer(lecturer);
        return "redirect:/lecturers/list";
    }
    @GetMapping("/delete")
    public String deleteLecturer(@RequestParam("lecturerNumber") String lecturerNumber) {
        lecturerService.deleteLecturer(lecturerNumber);
        return "redirect:/lecturers/list";
    }
}
