package org.example.stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
public class Hooks {
    public static WebDriver driver;
    @Before
    public static void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.50");
        options.addExtensions(new File("src/main/resources/Features/AdBlock-—-best-ad-blocker.crx"));
        options.addExtensions(new File("src/main/resources/Features/NopeCHA-CAPTCHA-Solver.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String mainWindow = iterator.next();
        String popupWindow = iterator.next();
        driver.switchTo().window(popupWindow).close();
        driver.switchTo().window(mainWindow);
        driver.get("https://homzmart.com/en");
    }
    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

