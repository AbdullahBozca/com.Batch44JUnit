package day06_Junit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        //3- cookies uyarisini kabul ederek kapatin

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("nutella"+Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
        ////div[@id='result-stats']
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiStr=sonucSayisiElementi.getText();
        String sonucKelimeleriArr[]=sonucSayisiStr.split(" ");
        String sonucSayisi=sonucKelimeleriArr[1].replaceAll("\\D","");
        int nutellaAramaSonucu=Integer.parseInt(sonucSayisi);
        if (nutellaAramaSonucu>10000000)
            System.out.println("sonuç 10 milyondan fazla");
        else
            System.out.println("sonuç 10 millondan az");

        //8-Sayfayi kapatin
        driver.close();
    }
}
