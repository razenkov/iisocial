import bot.Base;
import bot.User;
import bot.Wait;
import core.WebDriverTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Random;

public class Main extends WebDriverTestBase {

    //private WebDriver driver;
    //private WebDriverManager manager;
   // private String browser = System.getProperty("browser", "chrome");

    @Test
    public void main() throws InterruptedException {

        Base.addNewUser();
        Base.saveUsers();
        //Base.restoreUserBase();
        //Base.showUsers();
        User user = Base.getRandomUser();

         for(int i = 0; i < 100; ++i){
             user.loginToYoutube(driver);
             user.lookRandomvideo(driver);
             user.searchForVideo("vin diesel");
             Wait.asUser();
         }



        driver.get(user.baseURL);

        System.out.println();

//
//        while (true) {
//
//            User currentUser = Base.getRandomUser();
//            currentUser.loginToYoutube(driver);
//            currentUser.lookRandomvideo(driver);


//            manager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//            //options.addArguments("headless");
//            driver = new ChromeDriver(options);
//
//            driver.get("https://www.youtube.com/watch?v=R8cKK6swy24&t=21s");
//            int pause = new Random().nextInt(180000);
//            System.out.println("pause = " + pause);
//            Thread.sleep(pause);
//            driver.quit();
//            System.out.println(i++);

//        }




    }

}
