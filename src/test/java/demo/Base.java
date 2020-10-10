package demo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gittigidiyor.com/");
    }

    public void clickElementByXpath(String tag, String attr, String val){
        driver.findElement(By.xpath("//"+tag+"[@"+attr+"='"+val+"']")).click();
    }

    public void clickElementById(String id){
        driver.findElement(By.id(id)).click();
    }


    public void sendKeysToElementByName(String name, String keys){
        driver.findElement(By.name(name)).sendKeys(keys);
    }

    public void WebDriverWaitForSecondsUntilClickable(int seconds, String id){
        WebDriverWait webDriverWait = new WebDriverWait(driver,seconds);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public WebElement findElementByXpath(String tag, String attr, String val){
        return driver.findElement(By.xpath("//"+tag+"[@"+attr+"='"+val+"']"));
    }

    public  String getTextByXpath(String xpath){
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    public void  selectItemByValue(String value,String elementID){
        Select select = new Select(driver.findElement(By.id(elementID)));
        select.selectByValue(value);
    }

    public void selectItemByIndex(int index, String elementID){
        Select select = new Select(driver.findElement(By.id(elementID)));
        select.selectByIndex(index);
    }

    @After
    public void breakDown(){
        driver.quit();
    }

}
