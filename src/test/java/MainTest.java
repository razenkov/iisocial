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
        //Base.showUsers();


        User user = Base.getRandomUser(true);

        while (true) {

            WebDriver webDriver = driver;

            try {

                user = Base.getRandomUser(false);
                user.loginToYoutube(webDriver);
                user.lookRandomvideo(webDriver);
                System.out.println(user.getVideoDuration(webDriver));

                user.logout(webDriver);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                //user.logout(webDriver);
            }


        }


    }

}
