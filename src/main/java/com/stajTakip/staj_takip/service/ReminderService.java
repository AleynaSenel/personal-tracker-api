package com.stajTakip.staj_takip.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.stajTakip.staj_takip.dto.ReminderRequestDTO;
import com.stajTakip.staj_takip.entity.Reminder;
import com.stajTakip.staj_takip.repository.ReminderRepository;

@Service
public class ReminderService {    
    
    private final ReminderRepository reminderRepository;
    private final EmailService emailService;

    public ReminderService(ReminderRepository reminderRepository, EmailService emailService){  
        this.reminderRepository = reminderRepository;
        this.emailService = emailService;
    }

    public String saveReminder(ReminderRequestDTO dto){

        if(dto.getEventDate().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Hata! Geçmiş bir tarih için hatirlatici kuramazsiniz.");
        }
    
        Reminder reminder = new Reminder();   

        reminder.setTitle(dto.getTitle());
        reminder.setEventType((dto.getEventType()));
        reminder.setEventDate(dto.getEventDate());
        reminder.setDaysBeforeReminder(dto.getDaysBeforeReminder());
        reminder.setDescription(dto.getDescription());
        reminder.setCompleted(false);

        reminderRepository.save(reminder);

        return "Hatirlatici basariyla veritabanina kaydedildi!";
    }

    // Zamanlayıcı (Scheduler) her uyandığında bu metodu çağıracak
    public void processUpcomingReminders() {
        
        LocalDate bugun = LocalDate.now(); 
        
        // Depodan sadece tamamlanmamış görevleri listelemesini istiyoruz
        List<Reminder> aktifGorevler = reminderRepository.findByIsCompletedFalse();
      
        for (Reminder reminder : aktifGorevler) {
            
            LocalDate bildirimTarihi = reminder.getEventDate().minusDays(reminder.getDaysBeforeReminder()); 
            
            if(bildirimTarihi.equals(bugun)){

                String mailKonusu = "⏳ Hatırlatma: " + reminder.getTitle() + " Yaklaşıyor!";
                String mailIcerigi = "Merhaba,\n\n" 
                                + "Kayıtlı etkinliklerinden biri için zaman daralıyor!\n\n"
                                + "📌 Etkinlik: " + reminder.getTitle() + "\n"
                                + "📅 Tarih: " + reminder.getEventDate() + "\n"
                                + "📝 Açıklama: " + reminder.getDescription() + "\n\n"
                                + "Başarılar dileriz!\n"
                                + "- Senin Akıllı Asistanın ";

                // Postacıya teslim ediyoruz
                emailService.sendEmail("aleysenell@gmail.com", mailKonusu, mailIcerigi);
                
                // SPAM ENGELLEYİCİ: E-posta gittikten sonra görevi kapat ve kaydet
                reminder.setCompleted(true);
                reminderRepository.save(reminder);
                System.out.println("Log: " + reminder.getTitle() + " için e-posta gönderildi ve görev kapatıldı.");
            }
        }
    }
}