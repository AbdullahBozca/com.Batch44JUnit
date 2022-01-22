package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C03_ilkTestMetodu {
    WebDriver driver;

    @Before
    public void ayarlariDuzenle() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void ortalıgıToplar() {
        driver.close();
    }

    @Test
    public void test01() {
        //amazon.com gidelim title in amazon içerdiğini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String arananKelime = "amazon";
        if (actualTitle.contains(arananKelime))
            System.out.println("amazon testi PASSED");
        else
            System.out.println("amazon testi FAILED");
    }

    @Test
    public void test02() {
        //google gidelim ve başlığın google içerdiğini test edelim

        driver.get("https://www.google.com");
        String actualTitle=driver.getTitle();
        String arananKelime="google";
        if (actualTitle.contains(arananKelime))
            System.out.println("google testi PASSED");
        else
            System.out.println("google testi FAILED");

    }
}
