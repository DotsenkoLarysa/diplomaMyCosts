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

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date parseTimestamp(String timestamp){
        try{
            return DATE_TIME_FORMAT.parse(timestamp);
        } catch(ParseException e){
            throw new IllegalArgumentException(e);
        }
    }

}
