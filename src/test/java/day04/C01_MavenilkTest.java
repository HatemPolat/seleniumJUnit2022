package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenilkTest {

    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");
        //   2- arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        WebElement aramaYapalim= driver.findElement(By.id("twotabsearchtextbox"));
     aramaYapalim.sendKeys("Samsung headphones", Keys.ENTER);
     // 4- Bulunan sonuc sayisini yazdiralim
       WebElement aramaSonucuYazdir= driver.findElement(By.
               xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println("aramaSonucu = " + aramaSonucuYazdir.getText());
        // 5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        // 6-Sayfanin tum basliklarini yazdiralim.
        System.out.println("h1 tagi basliklari = " + driver.findElement(By.xpath("//h1")).getText());
        System.out.println("h2 tagi basliklari = " + driver.findElement(By.xpath("//h2")).getText());
        System.out.println("h3 tagi basliklari = " + driver.findElement(By.xpath("//h3")).getText());

        driver.close();





    }
}
