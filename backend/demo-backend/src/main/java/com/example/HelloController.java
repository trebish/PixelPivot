package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.DayOfWeek;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World from Spring Boot!!!";
    }

    @GetMapping("/day-of-week")
    public String getDayOfWeek() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        return day.toString();
    }

}