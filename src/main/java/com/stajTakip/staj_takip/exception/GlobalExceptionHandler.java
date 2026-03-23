package com.stajTakip.staj_takip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //tüm projeyi izleyen bir güvenlik ağı
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        
        // ex.getMessage() kodu, senin Service katmanında yazdığın o "Hata! Geçmiş bir tarih..." metnini alır.
        // GÖREV SENİN: Bu metni ve HTTP 400 (Bad Request) durum kodunu kullanıcıya geri dön.
        
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    
    }
}
