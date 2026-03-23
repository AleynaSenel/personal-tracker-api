package com.stajTakip.staj_takip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stajTakip.staj_takip.dto.ReminderRequestDTO;
import com.stajTakip.staj_takip.service.ReminderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reminders")
public class ReminderController {      //HTTP isteklerini dinleyecek    DTO paketini teslim alır. 

    @PostMapping
    public String createReminder(@RequestBody ReminderRequestDTO requestDTO) {
       
       /*  System.out.println("Postman'den gelen firma/ders: " + requestDTO.getTitle());
        System.out.println("Postman'den gelen tarih: " + requestDTO.getEventDate());
        
        return "Veri Spring Boot'a basariyla ulasti.";           dto dan gelen paket direkt buraya yönlendiriliyordu */   

        // Gelen paketi (requestDTO) doğrudan Service katmanına gönderiyoruz.  Servis bu paketi işleyecek, veritabanına kaydedecek ve bize bir String mesaj dönecek.

        String sonucMesaji = reminderService.saveReminder(requestDTO);
        return sonucMesaji;
    }

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService){
        this.reminderService = reminderService;
    }
    
    
}
