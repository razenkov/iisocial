import bot.Base;
import bot.User;
import core.WebDriverTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MainTest extends WebDriverTestBase {


    @Test
    public void main() throws InterruptedException {


        Base.add3NewUsers();
        //Base.restoreUserBase();
        Base.showUsers();

        while (true) {

            WebDriver webDriver = driver;
            User user = Base.getRandomUser();

            try {

                user.loginToYoutube(webDriver);
                user.lookRandomvideo(webDriver);
                System.out.println(user.getVideoDuration(webDriver));

                user.logout(webDriver);
                System.out.println();


            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                user.logout(webDriver);
            }


        }


    }

}
