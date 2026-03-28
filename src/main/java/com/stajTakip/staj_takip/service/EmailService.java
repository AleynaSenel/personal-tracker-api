package com.stajTakip.staj_takip.service;

// Yeni eklenen kütüphane
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    // Ayar dosyasındaki e-posta adresini bu değişkene çekeriz
    @Value("${spring.mail.username}")
    private String fromEmail;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);             
        message.setSubject(subject);   
        message.setText(body);         

        // dinamik değişken kullanıyoruz
        message.setFrom(fromEmail); 

        javaMailSender.send(message);
        
        System.out.println("Sistem logu: E-posta başarıyla iletildi -> Alıcı: " + to);
    }
}