package com.stajTakip.staj_takip.dto;

import java.time.LocalDate;

public class ReminderRequestDTO {  //dışarıdan gelecek olan veriyi karşılayacak sınıf
                                    //postmanden girilecek değerler(verinin şeklini tasarladık)
    private String title;                       //Reminder sınıfıyla değişken isimlerinin aynı olması avantaj ama farklı da olabilirdi
    private String eventType;
    private LocalDate eventDate;
    private int daysBeforeReminder;
    private String description;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public int getDaysBeforeReminder() {
        return daysBeforeReminder;
    }
    public void setDaysBeforeReminder(int daysBeforeReminder) {
        this.daysBeforeReminder = daysBeforeReminder;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
