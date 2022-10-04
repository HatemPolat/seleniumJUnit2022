package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    /*
1- Bir class oluşturun: DropDown
2- https://the-internet.herokuapp.com/dropdown adresine gidin.
3- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4- Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
5- Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
6- Tüm dropdown değerleri(value) yazdırın
7- Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
  */
    // //https://the-internet.herokuapp.com/dropdown adresine gidin.
    WebDriver driver;
    Select select;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();

    }
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //3- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
                //3- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddmList= driver.findElement(By.xpath("//*[@id='dropdown']"));
        select=new Select(ddmList);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================================");
        //4- Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //5- Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        System.out.println("============================================");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //6- Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumddmList1=select.getOptions();
        tumddmList1.forEach(t-> System.out.println(t.getText()));
        /*
        for (WebElement w: tumddmList1) {
                  System.out.println(w.getText());} */
        //7- Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("tumddmList1.size() = " + tumddmList1.size());
        if (tumddmList1.size() == 4){
            System.out.println("True");
        }else System.out.println("False");

    }

}
