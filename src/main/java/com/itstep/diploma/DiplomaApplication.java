package com.itstep.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DiplomaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiplomaApplication.class, args);
    }
//    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
//    private Date parseDate(String date){
//        try{
//            return new Date(DATE_FORMAT.parse(date).getTime());
//        } catch(ParseException e){
//            throw new IllegalArgumentException(e);
//        }
//    }

}
