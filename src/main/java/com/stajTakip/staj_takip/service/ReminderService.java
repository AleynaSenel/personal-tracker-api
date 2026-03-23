package com.stajTakip.staj_takip.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.stajTakip.staj_takip.dto.ReminderRequestDTO;
import com.stajTakip.staj_takip.entity.Reminder;
import com.stajTakip.staj_takip.repository.ReminderRepository;

@Service
public class ReminderService {    //controllerdaki veriyi alır ve bunu işletir. işlem yapar. tarih geçmiş mi ? bilgi eksik mi diye
    // her şey uygunsa paketi veritabanı formatına çevirir
    
   private final ReminderRepository reminderRepository;

   public ReminderService(ReminderRepository reminderRepository){  // constructer
     this.reminderRepository = reminderRepository;
   }

   public String saveReminder(ReminderRequestDTO dto){

    if(dto.getEventDate().isBefore(LocalDate.now())){
        throw new IllegalArgumentException("Hata! Geçmiş bir tarih için hatirlatici kuramazsiniz.");
    }

    Reminder reminder = new Reminder();   // veritabanına eklenecek entity oluşturuyoruz.  

    reminder.setTitle(dto.getTitle());
    reminder.setEventType((dto.getEventType()));
    reminder.setEventDate(dto.getEventDate());
    reminder.setDaysBeforeReminder(dto.getDaysBeforeReminder());
    reminder.setDescription(dto.getDescription());

    reminder.setCompleted(false);

    reminderRepository.save(reminder);


    return "Hatirlatici basariyla  veritabanina kaydedildi!";
   }
    
    
}
