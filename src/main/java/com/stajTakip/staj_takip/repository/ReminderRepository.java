package com.stajTakip.staj_takip.repository;

import com.stajTakip.staj_takip.entity.Reminder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 

public interface ReminderRepository extends JpaRepository<Reminder, Long>{
      // veri tabanı interface. sadece servise katmanından emir alır.

      List<Reminder> findByIsCompletedFalse();
    
}
