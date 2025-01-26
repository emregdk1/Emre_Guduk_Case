# Emre_Guduk_Case

# Insider UI Web Test Otomasyonu

## **Genel Bakış**
Bu proje, Insider web sitesinin **Kariyer** ve **Quality Assurance (Kalite Güvencesi)** sayfalarının doğruluğunu ve kullanıcı arayüzü davranışlarını test etmek için geliştirilmiştir.

Testler, **Cucumber** kullanılarak yazılmıştır ve Davranış Odaklı Geliştirme (Behavior-Driven Development - BDD) prensiplerini takip etmektedir.

---

## **Feature Dosyası: Insider UI Test Case**

### **Feature Adı**
`Insider UI Test Case`

### **Açıklama**
Test, aşağıdaki senaryoları doğrular:
- Kariyer ve Quality Assurance sayfaları için doğru yönlendirme ve URL kontrolü.
- QA iş pozisyonlarını filtreleme ve "View Role" (Rolü Görüntüle) butonunun doğruluğu.
- Lever iş platformu ile entegrasyon ve sayfa geçişlerinin kontrolü.

---

## **Test Senaryoları**

### **Arka Plan**
- Tarayıcı sürücüsünü `Chrome` ile başlat. (chrome yerine `firefox` ile de çalıştırabilir.)
- Insider ana sayfasına git: `https://useinsider.com/`.

### **Senaryo: InsiderUITestCase**
1. URL'nin `https://useinsider.com/` içerdiğini doğrula.
2. Çerez (cookie) onaylama popup'ını kabul et.
3. Kariyer sayfasına git ve şu değerleri doğrula:
    - Şirket: `True`
    - Kariyer: `True`
4. URL'nin `https://useinsider.com/careers/` içerdiğini doğrula.
5. Kariyer sayfasındaki şu bölümleri doğrula:
    - Lokasyon Kontrolü: `True`
    - Insider'da Hayat Kontrolü: `True`
6. Quality Assurance sayfasına git:
    - URL: `https://useinsider.com/careers/quality-assurance/`.
7. "Tüm QA İşlerini Gör" sayfasına git:
    - URL: `https://useinsider.com/careers/open-positions/?department=qualityassurance`.
8. "QUALITY ASSURANCE" yazısının yüklenmesini bekle.
9. QA işlerini şu kriterlere göre filtrele:
    - Pozisyonları Filtrele: `SEE_ALL_QA_JOBS`
    - Lokasyon Seç: `Location`
    - Departman Seç: `Department`.
10. "View Role" butonunun yüklenmesini bekle.
11. "View Role" butonunun üzerine gel ve tıkla.
12. Yeni pencereye geçiş yap.
13. URL'nin `https://jobs.lever.co/useinsider` içerdiğini doğrula.
14. Lever platformundaki filtre kontrol metnini doğrula.

---

## **Çalıştırma Talimatları**

### **Ön Gereksinimler**
- Aşağıdaki yazılımların kurulu olduğundan emin olun:
    - Java (sürüm 8 veya üstü)
    - Maven
    - Uyumluluk için tarayıcı sürücüsü (örneğin, Chrome için ChromeDriver)




# JMeter Load Test - N11 Search Test Plan

## **Genel Bakış**
Bu Java uygulaması, JMeter'ın programatik bir şekilde kullanılmasıyla **N11 arama sayfası** için bir yük testi planı oluşturur ve çalıştırır. Kod, bir **"arama"** isteği göndererek HTTP yanıt kodu ve yanıt gövdesini doğrular.

---

## **Kodun İşlevleri**
1. **Arama İsteği (Search Request):**
    - URL: `https://www.n11.com/arama?q=<aranan_kelime>`
    - HTTP Metodu: `GET`
    - Test edilen kelime: `phone` (varsayılan)

2. **Yanıt Doğrulamaları:**
    - **Yanıt Gövdesi Doğrulaması:** Yanıt verilerinde aranan kelimenin (`phone`) geçerli olup olmadığını kontrol eder.
    - **HTTP Yanıt Kodu Doğrulaması:** Yanıt kodunun `200` olduğunu kontrol eder.

3. **Yük Testi Planı:**
    - **Döngü Kontrolcüsü:** Her test isteği bir kez çalıştırılır.
    - **Thread Group:**
        - Kullanıcı Sayısı (Threads): `1`
        - Ramp-Up Süresi: `1 saniye`

4. **Sonuçların Toplanması:**
    - Çıktılar `test-results.jtl` dosyasına kaydedilir.

5. **Konsol Mesajı:**
    - Test tamamlandığında konsolda şu mesaj gösterilir:
      ```
      Test Completed! Results saved to: test-results.jtl
      ```

---

## **Kullanım**

### **Ön Gereksinimler**
- Java 8 veya üzeri bir sürüm yüklü olmalıdır.
- Maven veya JMeter kütüphaneleriyle çalıştırılabilir.
- `Jmeter.properties` dosyası, `src/test/resources/` dizininde bulunmalıdır.





# Pet Store CRUD APİ Test Otomasyonu

## **Genel Bakış**
Bu proje, Swagger Petstore API'si için CRUD (Oluşturma, Okuma, Güncelleme ve Silme) işlemlerini test etmek amacıyla oluşturulmuş bir otomasyon projesidir. Testler **Rest Assured** kullanılarak yazılmıştır ve doğrulama için **JUnit** kütüphanesi kullanılmıştır.

---

## **Kodun İşlevleri**
Bu sınıf, aşağıdaki test senaryolarını içerir:

### **1. Pet Oluşturma (Create)**
- **Test Adı:** `createPetPositive`
- **Açıklama:** API kullanılarak bir evcil hayvan (pet) oluşturulur. Yanıt gövdesi ve durum kodu doğrulanır.
- **Beklenen Durum Kodu:** `200`

- **Test Adı:** `createPetNegativeInvalidBody`
- **Açıklama:** Geçersiz bir JSON gövdesi gönderildiğinde, API'nin bir hata döndürmesi beklenir.
- **Beklenen Durum Kodu:** `400`

---

### **2. Pet Okuma (Read)**
- **Test Adı:** `readPetPositive`
- **Açıklama:** Var olan bir evcil hayvanın (pet) detayları alınır ve doğrulanır.
- **Beklenen Durum Kodu:** `200`

- **Test Adı:** `readPetNegativeNotFound`
- **Açıklama:** Var olmayan bir evcil hayvan sorgulandığında, API'nin `404 Not Found` döndürmesi beklenir.
- **Beklenen Durum Kodu:** `404`

---

### **3. Pet Güncelleme (Update)**
- **Test Adı:** `updatePetPositive`
- **Açıklama:** Mevcut bir evcil hayvanın detayları güncellenir ve değişikliklerin doğru olduğu doğrulanır.
- **Beklenen Durum Kodu:** `200`

---

### **4. Pet Silme (Delete)**
- **Test Adı:** `deletePetPositive`
- **Açıklama:** Mevcut bir evcil hayvan API kullanılarak silinir.
- **Beklenen Durum Kodu:** `200`

- **Test Adı:** `deletePetNegative_NotFound`
- **Açıklama:** Var olmayan bir evcil hayvan silinmeye çalışıldığında, API'nin `404 Not Found` döndürmesi beklenir.
- **Beklenen Durum Kodu:** `404`

---

## **Test Çalıştırma Talimatları**

### **Ön Gereksinimler**
- Java 8 veya üstü
- Maven
- IDE (IntelliJ IDEA, Eclipse vb.)
- Swagger Petstore API'nin erişilebilir olduğundan emin olun: `https://petstore.swagger.io/v2`
