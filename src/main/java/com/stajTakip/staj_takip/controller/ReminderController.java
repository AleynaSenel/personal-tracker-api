package com.stajTakip.staj_takip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stajTakip.staj_takip.dto.ReminderRequestDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reminders")
public class ReminderController {      //HTTP isteklerini dinleyecek

    @PostMapping
    public String createReminder(@RequestBody ReminderRequestDTO requestDTO) {
       
        System.out.println("Postman'den gelen firma/ders: " + requestDTO.getTitle());
        System.out.println("Postman'den gelen tarih: " + requestDTO.getEventDate());
        
        return "Veri Spring Boot'a basariyla ulasti.";
    }
    
    
}
