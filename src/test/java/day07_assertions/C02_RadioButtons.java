package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {
   WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01() throws InterruptedException {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //-
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']")).click();
        //-“radio buttons” elementlerini locate edin
        driver.findElement(By.xpath("//input[@value='2']")).click();
        //Secili degilse cinsiyet butonundan size uygun olani secin
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        Thread.sleep(3000);

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
