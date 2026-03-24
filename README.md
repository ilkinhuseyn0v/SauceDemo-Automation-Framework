# SauceDemo Automation Framework

Selenium əsaslı UI test automation framework - [SauceDemo](https://www.saucedemo.com/) web tətbiqi üçün.

##  Texnologiyalar

- **Java** - Proqramlaşdırma dili
- **Selenium WebDriver** - Brauzer avtomatlaşdırması
- **TestNG** - Test framework
- **Allure Report** - Test hesabatları
- **Maven** - Asılılıq idarəetməsi

##  Xüsusiyyətlər

- Page Object Model (POM) dizayn pattern
- Data-driven testing dəstəyi
- Cross-browser testing (Chrome, Firefox, Edge)
- Parallel test icra
- Ətraflı Allure hesabatları
- Test uğursuz olduqda screenshot
- Təkrar istifadə edilən utility metodları

##  Quraşdırma

### Tələblər

- Java JDK 8 və ya daha yüksək
- Maven 3.6+
- Chrome/Firefox/Edge brauzer

### Quraşdırma Addımları

1. Repository-ni klonla:
```bash
git clone https://github.com/ilkinhuseyn0v/SauceDemo-Automation-Framework.git
cd SauceDemo-Automation-Framework
```

2. Asılılıqları quraşdır:
```bash
mvn clean install
```

### Testlərin İcrası

Bütün testləri işə sal:
```bash
mvn clean test
```

Müəyyən test suite işə sal:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

Allure hesabatı yarat:
```bash
mvn allure:serve
```

##  Test Coverage

- Login funksionallığı (düzgün/yanlış məlumatlar)
- Məhsul siyahısı və filtrasiya
- Səbətə əlavə etmə
- Checkout prosesi
- Sifariş tamamlanması

##  Allure Report

Allure ətraflı test icra hesabatları təqdim edir:
- Test icra timeline
- Uğursuz testlərin screenshot-ları
- Addım-addım test logları
- Test kateqoriyalaşdırması
- Tarixçə trendləri

##  Konfiqurasiya

`src/main/resources/config.properties` faylını yenilə:
```properties
browser=chrome
baseUrl=https://www.saucedemo.com
timeout=10
headless=false
```

##  Test Məlumatları

- Standard User: `standard_user` / `secret_sauce`
- Locked Out User: `locked_out_user` / `secret_sauce`
- Problem User: `problem_user` / `secret_sauce`

##  Töhfə

1. Repository-ni fork et
2. Feature branch yarat (`git checkout -b feature/yeni-test`)
3. Dəyişiklikləri commit et (`git commit -m 'Yeni test əlavə et'`)
4. Branch-a push et (`git push origin feature/yeni-test`)
5. Pull Request aç

##  Lisenziya

Bu layihə MIT Lisenziyası ilə lisenziyalaşdırılıb.

##  Müəllif

**Ilkin Huseynov**  
QA Automation Engineer

---

 Layihə faydalıdırsa, ulduz verməyi unutma!
EOF
