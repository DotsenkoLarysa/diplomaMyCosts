package com.itstep.diploma.controller;

import com.itstep.diploma.model.Category;
import com.itstep.diploma.model.Journal;
import com.itstep.diploma.model.Transaction;
import com.itstep.diploma.model.User;
import com.itstep.diploma.service.JournalService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/journals")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("listJournals", journalService.listAll());
        return "journal";
    }

    @GetMapping(value = {"/add_form1", "/add_form3"})
    public String showAddForm3(Model model) {
        Journal journal = new Journal();
        journal.setEvent_date(new Date());
        journal.setCategory(new Category());
        journal.setTransaction(new Transaction());
        journal.setUser(new User());
        model.addAttribute("journalNew", journal);
        return "addJournal";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("journalNew") @Valid Journal journal, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/journals/add_form3";
        }
        journalService.save(journal);
        return "redirect:/journals/all";
    }

    @GetMapping("/edit/{event_id}")
    public String showEditForm(Model model, @PathVariable Long event_id) {
        model.addAttribute("journals", journalService.get(event_id));
        return "editJournalForm";
    }
}
