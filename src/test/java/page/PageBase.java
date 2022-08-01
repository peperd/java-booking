package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BookingSearchTest;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static page.constants.Constant.Const.TEST_ANNOTATION;

public class PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    // Wait wrapper method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    // Method get element
    public WebElement getElement(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy);
    }

    //Create list of results and verify
    public void verifySearchList(By elementBy, String value) {
        List<String> list = new java.util.ArrayList<>(List.of());
        List<WebElement> elements = driver.findElements(elementBy);
        for (WebElement element : elements) {
            String el = element.getText();
            list.add(el);
        }
        for (String element : list) {
            Assertions.assertTrue(element.contains(value));
        }
    }

    public static void reflectionOnTest() throws IOException {
        List<String> result = new java.util.ArrayList<>(List.of());
        Class<BookingSearchTest> SearchTest = BookingSearchTest.class;
        Method[] methods = SearchTest.getMethods();
        int i = 0;
        FileWriter writer = null;
        for (Method method : methods) {
            if (Arrays.toString(method.getAnnotations()).equals(TEST_ANNOTATION)) {
                i++;
                result.add(String.valueOf(i));
                result.add(Arrays.toString(method.getAnnotations()));
            }
            writer = new FileWriter("result.txt");
            writer.write(result +","+ System.getProperty("line.separator"));
        }
        assert writer != null;
        writer.close();
    }
}
