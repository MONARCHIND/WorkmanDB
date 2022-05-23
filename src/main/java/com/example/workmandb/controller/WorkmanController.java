package com.example.workmandb.controller;

import com.example.workmandb.model.Workman;
import com.example.workmandb.service.WorkmanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller()
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
    @GetMapping("/showAllFemale")
    public String showAllFemale(Model model){
        List<Workman> femaleList = workmanService.getAllFemale();
        model.addAttribute("femaleList", femaleList);
        return "showAllFemale";
    }

    @GetMapping("/findById")
    public String findByIdForm(Model model){
        model.addAttribute("workman", new Workman());
        return "findByIdForm";
    }
    @PostMapping("/findById")
    public String findById(@ModelAttribute Workman workman, Model model){
        List<Workman> idList = workmanService.findById(workman.getId());
        model.addAttribute("idList", idList);
        return "findById";
    }

    @GetMapping("/findByName")
        public String findByNameForm(Model model){
        model.addAttribute("workman", new Workman());
        return "findByNameForm";
    }
    @PostMapping("/findByName")
    public String findByName(@ModelAttribute Workman workman, Model model){
        List<Workman> namesList = workmanService.findByName(workman.getFirstName());
        model.addAttribute("namesList", namesList);
        return "findByName";
    }

    @GetMapping("/findBySurname")
    public String findBySurnameForm(Model model){
        model.addAttribute("workman", new Workman());
        return "findBySurnameForm";
    }
    @PostMapping("/findBySurname")
    public String findBySurname(@ModelAttribute Workman workman, Model model){
        List<Workman> surnamesList = workmanService.findBySurname(workman.getLastName());
        model.addAttribute("surnameList", surnamesList);
        return "findBySurname";
    }
}
