package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04JUnitCheckBox {
/*
a)Verilen web sayfasina gidiniz
https://the-internet.herokuapp.com/checkboxes
b) Checkbox1 ve Checkbox2 Elementlerini locate ediniz
c) Checkbox1 secili degilse onay kutusunu tiklayiniz
d) Checkbox2 secili degilse onay kutusunu tiklayiniz
 */
WebDriver driver;
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
   // @After
    public void teardown(){
        driver.close();
    }


    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkboxe1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkboxe2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checkboxe1.isSelected()){
            checkboxe1.click();
        }
        if (!checkboxe2.isSelected()){
            checkboxe2.click();
        }

    }
}
