package calismaDosyasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

public class C01_IlkIMtihanimTest extends TestBaseBeforeAfter {
//1-Amazon a git
//2-Kategori kısmına gel
//3_Baby i seçin
//4_Arama kutusuna baby toys yazalım ve aratalım
//5-Sayfanın alt kısımlarından Skip Hop Bandana Buddies ürününü seçin
//6-Fiyatın 11.99 olduğunu test edin
//7_Add to cart ı(sepete ekle) click yapın
//8_Go to cart ı(sepete git) click yapın
//9_This order contains a gift kutucuğunu işaterledikten sonra
    //proceed to chec i click yapın

///10_email girin ve devam ı işaretletin


    @Test
    public void Test1() {
        //1-Amazon a git
        driver.get("https://amazon.com");
        //2-Kategori kısmına gel
        //        WebElement dropBox=driver.findElement(By.xpath("(//*[@id='searchDropdownBox'])[1]"));
        //        Select select=new Select(dropBox);
        //        //3_Baby i seçin
        //        select.selectByVisibleText("Baby");
        //        //4_Arama kutusuna baby toys yazalım ve aratalım
        //        //WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        //       //action.moveToElement(searchBox).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();
        WebElement signBox=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));

        signBox.click();

        action.moveToElement(driver.findElement(By.xpath("//*[@id='ap_email']"))).
                sendKeys("polathatem3653@gmail.com").sendKeys(Keys.TAB).click().click().perform();






    }
}
