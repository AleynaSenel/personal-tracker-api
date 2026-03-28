# 🚀 Akıllı Staj ve Etkinlik Takip API'si

Kullanıcıların staj başvurularını, sınavlarını ve mülakatlarını takip etmelerini sağlayan tam otomatik bir Spring Boot REST API projesi. Sistem, arka planda çalışan bir zamanlayıcı (scheduler) sayesinde her gün yaklaşan etkinlikleri kontrol eder ve kullanıcıya otomatik olarak akıllı e-posta hatırlatıcıları gönderir.

## 🌟 Temel Özellikler
* **Görev Yönetimi (CRUD):** Yaklaşan etkinliklerinizi oluşturun ve takip edin.
* **Akıllı Zamanlayıcı (Scheduler):** Arka planda kendi kendine çalışan `@Scheduled` robotu.
* **E-Posta Entegrasyonu:** `JavaMailSender` kullanılarak hazırlanan dinamik ve otomatik e-posta bildirimleri.
* **Global Hata Yönetimi:** `@ControllerAdvice` ile hataları (örneğin geçmiş tarih girilmesi) zarif bir şekilde yakalama ve kullanıcıya anlamlı HTTP 400 mesajları dönme.
* **İnteraktif API Vitrini:** Swagger UI (OpenAPI) entegrasyonu sayesinde Postman'e ihtiyaç duymadan tarayıcı üzerinden API testi yapabilme.

## 🛠️ Kullanılan Teknolojiler
* **Java 17+**
* **Spring Boot 3** (Web, Data JPA, Mail)
* **H2 Database** (Bellek İçi Veritabanı)
* **Swagger / OpenAPI** (API Dokümantasyonu)
* **Maven**

## 🚦 Kurulum ve Çalıştırma

1. Projeyi kendi bilgisayarınıza klonlayın.
2. **⚠️ ÖNEMLİ GÜVENLİK ADIMI:** E-posta bildirim sisteminin çalışması için projenin e-posta ayarlarına kendi bilgilerinizi girmelisiniz. 
   * İlgili ayar dosyasını (`application.properties` veya ortam değişkenlerinizi/`launch.json`) açın.
   * `spring.mail.username` kısmına kendi Gmail adresinizi girin.
   * `spring.mail.password` kısmına Google hesabınızdan alacağınız **16 haneli Uygulama Şifresini** girin. *(Güvenliğiniz için gerçek şifrenizi asla bu dosyaya yazıp GitHub'a yüklemeyin!)*
3. Ana sınıf olan `StajTakipApplication.java` üzerinden projeyi çalıştırın.
4. Tarayıcınızı açın ve interaktif API vitrinini görmek için şu adrese gidin: 
   👉 `http://localhost:8080/swagger-ui/index.html`

## 📬 İletişim
* **Geliştirici:** Aleyna Şenel
* **E-Posta:** aleysenell@gmail.com
