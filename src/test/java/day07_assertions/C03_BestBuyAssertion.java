package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertion {
    //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki
    //testleri yapin
    //○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
    //○titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
    //○logoTest => BestBuy logosunun görüntülen digini test edin
    //○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get("https://www.bestbuy.com/");
        String actualUrl = driver.getCurrentUrl();
        String arananUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(arananUrl, actualUrl);

        String arananKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKelime));

        WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo görünmüyor",logoElement.isDisplayed());

        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francais.isDisplayed());

    }

    @After
    public void tearDown() {
        //driver.close();
    }
}
