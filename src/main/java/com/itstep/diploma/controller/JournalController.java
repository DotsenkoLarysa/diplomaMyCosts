package com.itstep.diploma.controller;

import com.itstep.diploma.model.Journal;
import com.itstep.diploma.repository.JournalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/journals")
public class JournalController {
    private final JournalRepository journalRepository;

    public JournalController(JournalRepository journalRepository) {

        this.journalRepository = journalRepository;
    }

    @GetMapping("/add_form3")
    public String showAddForm3(Journal journal){
        return "addWithdrawal";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("journals", journalRepository.findAll());
        return "addWithdrawal";
    }

    @PostMapping("/add3")
    public String addJournal3(@Valid Journal journal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addWithdrawal";
        }
        journalRepository.save(journal);
        return "redirect:/journals/add3";
    }


}
