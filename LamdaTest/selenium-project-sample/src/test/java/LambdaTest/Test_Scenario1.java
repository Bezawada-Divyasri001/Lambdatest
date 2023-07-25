package LambdaTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Test_Scenario1 {
	String username = "b.divyasri";
    String accesskey = "aMA4YQSMGXAUawgezjROWXuq3hyz478l7nh1cnaK9KoMa17EbC";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    public static void main(String[] args) {
        new Test_Scenario1().test();
    }
    public void test() {
        // To Setup driver
        setUp();
        try {
              //Change it to production page
            driver.get("https://www.lambdatest.com/selenium-playground/");

              //Let's mark done first two items in the list.
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/ul/li[1]/a")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[1]/div[2]/div/div[1]/input")).sendKeys("Welcome to LambdaTest");

             // Let's add an item in the list.
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[1]/div[2]/div/div[1]/button")).click();
           // driver.findElement(By.xpath("//*[@id=\\\"message\\\"]")).isDisplayed();
         // Let's check that the item we added is added in the list.
            String enteredText = driver.findElementByXPath("/html/body/div[1]/div/section[2]/div/div/div/div[1]/div[2]/div/div[2]/div/p").getText();
            if (enteredText.equals("Welcome to LambdaTest")) {
                status = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tearDown();
        }
    }
    private void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("build", "TestScenario_1");
        capabilities.setCapability("name", "TesetScenario_1");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit(); //really important statement for preventing your test execution from a timeout.
        }
    }
}


