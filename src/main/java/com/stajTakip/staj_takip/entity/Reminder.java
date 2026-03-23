package com.stajTakip.staj_takip.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity       //veritabanı bağlantısı
public class Reminder {                     //veritabanı tablosu

    @Id   //primary key olduğunu belirtiyoruz
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //id'lerin 1,2,3 olarak artmasını sağlar
    private Long id;

    private String title;
    private String eventType;
    private LocalDate eventDate;
    private int daysBeforeReminder;
    private String description;
    private boolean isCompleted;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    
    public boolean isCompleted(){   //getter da boolean is ile baslar(Nedeni: ing grammer yapısı/ standart)
        return isCompleted;
    }
    public void setCompleted(boolean isCompleted){  // setter da sadece set ile baslar.
        this.isCompleted = isCompleted;
    }
}
