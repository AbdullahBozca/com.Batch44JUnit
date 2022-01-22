package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Tekrar2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        //4. Login tusuna basin
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi=ilkUrun.getText();
        ilkUrun.click();


        //6. Add to Cart butonuna basin
        WebElement addButton=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();
        //7. Alisveris sepetine tiklayin
        WebElement alisverisSepetiButonu= driver.findElement(By.className("shopping_cart_link"));
        alisverisSepetiButonu.click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement kontrolKismi= driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrunIsmi=kontrolKismi.getText();
        if (sepettekiUrunIsmi.equals(ilkUrunIsmi))
            System.out.println("Alışveriş testi PASSED");
        else
            System.out.println("Alışveriş testi FAILED");
        //9. Sayfayi kapatin
       driver.close();
    }
}
