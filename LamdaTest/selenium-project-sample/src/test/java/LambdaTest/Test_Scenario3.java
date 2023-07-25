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
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Test_Scenario3 {
	String username = "b.divyasri";
    String accesskey = "aMA4YQSMGXAUawgezjROWXuq3hyz478l7nh1cnaK9KoMa17EbC";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    public static void main(String[] args) {
        new Test_Scenario3().test();
    }
    public void test() {
        // To Setup driver
        setUp();
        try {
              //Change it to production page
            driver.get("https://www.lambdatest.com/selenium-playground/");

              //Let's mark done first two items in the list.
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/ul/li[5]/a")).click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,200)", "");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click();
             // Let's add an item in the list.
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[1]/div[1]/input")).sendKeys("Divya");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[1]/div[2]/input")).sendKeys("Divya@gmail");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[1]/div[3]/input")).sendKeys("Divya!1234");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[2]/div[1]/input")).sendKeys("Zensar");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[2]/div[2]/input")).sendKeys("GoogleWebSite");
            Select Country =new Select(driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[3]/div[1]/select")));
			Country.selectByVisibleText("United States");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[3]/div[2]/input")).sendKeys("Vijayawada");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[4]/div[1]/input")).sendKeys("Konnamgunta");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[4]/div[2]/input")).sendKeys("Nuzvid");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[5]/div[1]/input")).sendKeys("AP");
            driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[5]/div[2]/input")).sendKeys("521201");
            
         
            // Let's check that the item we added is added in the list.
            String enteredText = driver.findElementByXPath("/html/body/div[1]/div/section[2]/div/div/div/div/p").getText();
            if (enteredText.equals("Thanks for contacting us, we will get back to you shortly.")) {
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
        capabilities.setCapability("build", "TestScenario3");
        capabilities.setCapability("name", "TestScenario_3");
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
