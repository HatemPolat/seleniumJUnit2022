package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
            /*
          Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
             BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
         BeforeAfter methodunda methodların static yapmaya gerek yok ama
                BeforeAfterCLass'da static yapmak zorunlu.
             */

    /*
   - Amazon sayfasına gidelim
   3 farklı test methodu oluşturalım
     a-Url'nin amazon içerdiğini test edelim
     b-Title'in facebook içermediğini test edelim
     c- sol üst köşede amazon logosunun göründüğünü test edelim
    */
   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //- Amazon sayfasına gidelim
        driver.get("https://www.Amazon.com");

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        //a-Url'nin amazon içerdiğini test edelim
        String url = "amazon";

        String urlamazon =driver.getCurrentUrl();
        Assert.assertTrue( urlamazon.contains(url));
    }
    @Test
    public void test2(){
        //b-Title'in facebook içermediğini test edelim
        String expectedTitle = "facebook";
        String actualTitle =driver.getTitle();
        Assert.assertFalse("Title not found",actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //c- sol üst köşede amazon logosunun göründüğünü test edelim

        WebElement actualLogo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(actualLogo.isDisplayed());
    }
}
