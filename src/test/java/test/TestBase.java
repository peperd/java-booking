package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.*;

import java.time.Duration;

public class TestBase{
    public Main main;
    public LandingPage landingPage;
    public ListingPage listingPage;
    WebDriver driver;

    @BeforeEach
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        main = PageFactory.initElements(driver, Main.class);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        listingPage = PageFactory.initElements(driver, ListingPage.class);
        main.goToPage();
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }

}
