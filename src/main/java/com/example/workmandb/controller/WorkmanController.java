package com.example.workmandb.controller;

import com.example.workmandb.model.Workman;
import com.example.workmandb.service.WorkmanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkmanController {

    WorkmanService workmanService;
    Workman workman;


    public WorkmanController(WorkmanService workmanService) {
        this.workmanService = workmanService;
    }

    @GetMapping("/showAll")
    public String showAllWorkman(Model model){
        List<Workman> workmanList = (List<Workman>) workmanService.getAllWorkman();
        model.addAttribute("workmanList", workmanList);
        return "showAll";
    }
}
