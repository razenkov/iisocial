package bot;

import core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.util.ArrayList;
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
    ArrayList<String> seachHistory;

    public User(String name, String soname, String email, String password) {
        this.name = name;
        this.soname = soname;
        this.password = password;
        this.email = email;
    }

    public void addToAlreadyWatchedVideo(String videoTitle) {
        if (seachHistory == null) {
            seachHistory = new ArrayList<>();
        }
        seachHistory.add(videoTitle);
    }

    public String getVideoTitle() {
        return driver.findElement(By.xpath("//*[@id='container']/h1/yt-formatted-string")).getText();
    }


    public void loginToYoutube(WebDriver driver) throws InterruptedException {

        Thread.sleep(5000);
        driver.get(baseURL);

        Thread.sleep(2000);


        boolean onetrue = false;

            // login btn
            try {
                driver.findElement(By.xpath("//*[@class='style-scope ytd-button-renderer style-blue-text size-default'][@id='text']")).click();
            } catch (Exception e) {
            }
            try {
                if (driver.findElement(By.xpath("//*[@id='identifierLink']")).isDisplayed()) {

                    List<WebElement> temp = driver.findElements(By.xpath("//*[@role='button']"));
                    for (WebElement e : temp) {
                        if (e.getText().equals("Сменить аккаунт")) {
                            e.click();
                        }
                    }

                    Thread.sleep(1000);
                } onetrue = true;
            } catch (Exception e) {
            }
       if(!onetrue) {
           try {

               System.out.println("Pre logged in stage. Need to choose another emaiil");
//click on prev loggined user
               if (driver.findElement(By.xpath("//*[@id='profileIdentifier']")).isDisplayed()) {
                   driver.findElement(By.xpath("//*[@id='profileIdentifier']")).click();
                   Thread.sleep(2000);
                   //change acc
                   List<WebElement> temp = driver.findElements(By.xpath("//*[@role='button']"));
                   for (WebElement e : temp) {
                       System.out.println("User tab: " + e.getText());
                       if (e.getText().equals("Сменить аккаунт") || e.getText().equals("Use another account")) {
                           e.click();
                       }
                   }

                   Thread.sleep(2000);
                   //driver.findElement(By.xpath("//*[@id='identifierLink']")).click();
                   Thread.sleep(1000);
               }
           } catch (Exception e2) {
           }
       }

         driver.findElement(By.xpath("//*[@type='email']")).sendKeys(this.email);


        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(this.password);

        Thread.sleep(2000);


        //next
        driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='avatar-btn']")).isDisplayed());
        System.out.println("Logged in to YouTube");
    }

    public void lookRandomvideo(WebDriver driver) throws InterruptedException {
        System.out.println("lookRandomvideo:");
        Thread.sleep(3000);
        //List<WebElement> temp = driver.findElements(By.cssSelector("#video-title"));

        //System.out.println(temp.size() + " - number of video titles on page.");
        //temp.get(new Random().nextInt(temp.size()-1)).click();

        driver.findElement(By.cssSelector("#video-title")).click();
        try {
            driver.findElement(
                    By.xpath("//*[@class='videoAdUiSkipButton videoAdUiAction videoAdUiFixedPaddingSkipButton']")).click();
            System.out.println("ADD was skipped.");
        } catch (Exception e) {
            System.out.println("Add is not present on video, so it was not skipped.");
        }
        this.getVideoDuration(driver);
        Thread.sleep(Wait.asUser());
    }

    public void searchForVideo(String searchRequest) throws InterruptedException {
        System.out.println("* searchForVideo");

        WebDriverWait wait = new WebDriverWait(driver, 10);

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

    public void logout(WebDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='style-scope ytd-topbar-menu-button-renderer no-transition']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        Thread.sleep(5000);

        System.out.println("Logout.");
    }

    public String getVideoDuration(WebDriver driver) {
        String time = "";
        String parts[];
        try {
            String temp;
            Thread.sleep(5000);
            temp = driver.findElement(By.xpath("//*[@class='ytp-progress-bar ']")).getAttribute("aria-valuetext");
            parts = temp.split(" ");
            time = parts[2];
            System.out.println("Current video duration: " + time);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Time was not pulled off.");
        }
        return time;
    }


}
