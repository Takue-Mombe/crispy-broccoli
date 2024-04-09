package org.thefinal.lecturerscompanionv2.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thefinal.lecturerscompanionv2.Services.LecturersService;
import org.thefinal.lecturerscompanionv2.Services.ProgrammeService;

@Controller
@RequestMapping("/admin")

public class AdminController {

    private final ProgrammeService programmeService;
    private final LecturersService lecturersService;

    public AdminController(ProgrammeService programmeService, LecturersService lecturersService) {
        this.programmeService = programmeService;
        this.lecturersService = lecturersService;
    }

    @GetMapping("/home")
    public String adminHome(Model model){
        Long programmeCount= programmeService.programmeCount();
        Long lecturerCount= lecturersService.lecturerCount();

        model.addAttribute("programmeCount",programmeCount);
        model.addAttribute("lecturerCount",lecturerCount);

        return "/Front/AdminDashboard";
    }
}
