package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
    /*
          ●https://www.amazon.com/ adresine gidin.
          -Test1
          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
          oldugunu testedin
          -Test2
          1.Kategori menusunden Books seceneginisecin
          2.Arama kutusuna Java yazin vearatin
          3.Bulunan sonuc sayisiniyazdirin
          4.Sonucun Java kelimesini icerdigini testedin
*/
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin.
        List<WebElement> drops=driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w: drops ) {
            System.out.println(w.getText());
             }
       int expecteddropSize=45;

        int dropSize=drops.size();
              Assert.assertNotEquals(expecteddropSize,dropSize);
              }

    @Test
    public void test2() {
        //1.Kategori menusunden Books seceneginisecin
       WebElement ddm =driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
        // 2.Arama kutusuna Java aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement element = driver.findElement(By.
                xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(element.getText());

        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedkelime="Java";
        String actualsonuc=element.getText();
        Assert.assertTrue(actualsonuc.contains(expectedkelime));
         }
}
