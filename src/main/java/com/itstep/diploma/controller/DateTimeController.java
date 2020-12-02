package com.itstep.diploma.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class DateTimeController {
    @PostMapping("/date")
    public void date(@RequestParam("date")
                     @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {

    }
    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate")
                          @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate localDate){

    }

    @PostMapping("/local-date-time")
    public void dateTime(@RequestParam("localDateTime")
                         @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")LocalDateTime localDateTime){

    }
}
