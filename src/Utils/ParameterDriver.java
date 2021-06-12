package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParameterDriver {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser","username", "password"})
    public void start(String browser,String username,String password)
    {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://demowebshop.tricentis.com/");

        loginTest(username,password);
    }

    @AfterClass
    public void stop() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


    void loginTest(String username,String password)
    {
        WebElement loginBtn=driver.findElement(By.linkText("Log in"));
        loginBtn.click();

        WebElement inputEmail= driver.findElement(By.id("Email"));
        inputEmail.sendKeys(username);

        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement login=driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        login.click();

    }
}
