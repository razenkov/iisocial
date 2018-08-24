package bot;

import core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class User extends WebDriverTestBase implements Serializable {

    WebDriver driver;

    public String name;
    public String soname;
    public String email;
    public String password;
    public Calendar dateOfBirth;
    public String language;
    public final String baseURL = "https://www.youtube.com/";

    public User(String name, String soname, String email, String password){
        this.name = name;
        this.soname = soname;
        this.password = password;
        this.email = email;
    }

    public void loginToYoutube(WebDriver driver) throws InterruptedException {

        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@class='style-scope ytd-button-renderer style-blue-text size-default'][@id='text']")).click();
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(this.email);


        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        //driver.findElement(By.xpath("//*[@type='email']")).submit();
        //driver.findElement(By.cssSelector("#identifierNext > div.ZFr60d.CeoRYc"));

        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(this.password);

        Thread.sleep(Wait.asUser());
        driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
        //driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).submit();
        //driver.findElement(By.cssSelector("#passwordNext > div.ZFr60d.CeoRYc")).click();
        System.out.println("Logged in to YouTube and videos has been seen");
    }

    public void lookRandomvideo(WebDriver driver) throws InterruptedException {
        System.out.println("* lookRandomvideo");
        driver.findElement(By.cssSelector("#video-title")).click();
        Thread.sleep(Wait.asUser());
    }

    public void searchForVideo(String searchRequest) throws InterruptedException {
        System.out.println("* searchForVideo");

        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='topbar-icons style-scope ytd-masthead']")));
        //driver.findElement(By.xpath("//*[@class='topbar-icons style-scope ytd-masthead']")).click();
        driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys(searchRequest + Keys.ENTER);

        List<WebElement> list = driver.findElements(By.xpath("//*[@id='channel-title']"));
        WebElement e = list.get(new Random().nextInt(list.size() - 1));

        e.click();

        String time = driver.findElement(By.xpath("//*[@class='ytp-time-duration']")).getText();
        System.out.println("time = " + time);

        list = driver.findElements(By.xpath("//*[@class='tab-content style-scope paper-tab']"));
        list.get(1).click();

        list = driver.findElements(By.xpath("//*[@id='video-title']"));

        System.out.println(list.size());

        WebElement e3 = list.get(new Random().nextInt(list.size() - 1));
        e3.click();


        Thread.sleep(100000);
    }

    public void registrateNewUser() {
        driver.get("https://www.google.com.ua/");
        driver.findElement(By.cssSelector("#gb_70")).click();

    }

    public void saveUserData() {

    }


}