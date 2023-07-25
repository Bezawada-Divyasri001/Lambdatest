package LambdaTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test_Scenario2 {

	String username = "b.divyasri";
    String accesskey = "aMA4YQSMGXAUawgezjROWXuq3hyz478l7nh1cnaK9KoMa17EbC";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    public static void main(String[] args) {
        new Test_Scenario2().test();
    }
    public void test() {
        // To Setup driver
        setUp();
        try {
        	driver.get("https://www.lambdatest.com/selenium-playground/");

            //Let's mark done first two items in the list.
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/ul/li[13]/a")).click();
          driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[2]/div[1]/div/input")).click();
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
      capabilities.setCapability("build", "TestScenario2");
      capabilities.setCapability("name", "TestScenario2");
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