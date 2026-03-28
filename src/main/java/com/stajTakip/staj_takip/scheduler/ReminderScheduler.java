package com.stajTakip.staj_takip.scheduler;

import com.stajTakip.staj_takip.service.ReminderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReminderScheduler {

    // Sadece ReminderService'e ihtiyacımız var
    private final ReminderService reminderService;

    // Bağımlılık Enjeksiyonu
    public ReminderScheduler(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @Scheduled(fixedRate = 10000) 
    public void checkUpcomingReminders() {
        System.out.println("Zamanlayıcı uyandı! Kontrol ediliyor...");
        
        // Bütün iş mantığını Service katmanındaki metoda devrettik
        reminderService.processUpcomingReminders();
    }
}