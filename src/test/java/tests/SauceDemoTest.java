package tests;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class SauceDemoTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Video için kapalı kalmalı
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException { // Throws ekledik
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // İzleyicinin siteyi görmesi için 2 sn bekle

        LoginPage loginPage = new LoginPage(driver);

        // Not: Login metodunu LoginPage içinde küçük beklemelerle güncelleyebilir
        // veya burada manuel elementlerle yavaşlatılmış şekilde gösterebilirsin:
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000); // Yazma işlemini görmeleri için 1 sn bekle

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000); // Giriş sonrası sayfayı görsünler

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "HATA: Giriş yapılamadı veya yanlış sayfa!");

        System.out.println("Test Başarılı: Başarıyla giriş yapıldı ve Ürünler sayfası görüldü.");
        Thread.sleep(2000); // Videoyu kapatmadan önce sonucu 2 sn ekranda tut
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}