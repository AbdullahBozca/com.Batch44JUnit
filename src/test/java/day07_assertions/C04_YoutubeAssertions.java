package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_YoutubeAssertions {
    //https://www.youtube.com adresine gidin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest() throws InterruptedException {
        //titleTest => Sayfa başlığının YouTube ” oldugunu test edin

        String arananTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananTitle));
        Thread.sleep(3000);
    }

    @Test
    public void imageTest() throws InterruptedException {
        //imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        WebElement logoElement = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void wrongTitleTest() throws InterruptedException {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String arananTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertFalse("title içinde youtube yok!", arananTitle.equals(actualTitle));
        Thread.sleep(3000);
    }

    @Test
    public void searchBox() throws InterruptedException {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElement.isEnabled());
        Thread.sleep(3000);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
