package com.example.workmandb.controller;

import com.example.workmandb.model.Workman;
import com.example.workmandb.service.WorkmanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkmanController {

    WorkmanService workmanService;


    public WorkmanController(WorkmanService workmanService) {
        this.workmanService = workmanService;
    }

    @GetMapping("/showAll")
    public String showAllWorkman(Model model){
        List<Workman> workmanList = workmanService.getAllWorkman();
        model.addAttribute("workmanList", workmanList);
        return "showAll";
    }
    @GetMapping("/showAllMale")
        public String showAllMale(Model model){
        List<Workman> maleList = workmanService.getAllMale();
        model.addAttribute("maleList", maleList);
        return "showAllMale";
        }



        @GetMapping("/findByName/{name}")
        public String findByName(@PathVariable("name") String name,Model model){
        List<Workman> namesList = workmanService.findByName(name);
        model.addAttribute("namesList", namesList);
        return "findByName";
        }

}
