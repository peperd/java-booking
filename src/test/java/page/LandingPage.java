package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static page.constants.Constant.Const.*;

public class LandingPage extends Main {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public By SEARCH_CITY_LOCATOR = By.id("ss");
    public By DATES = By.cssSelector("[class='xp__dates-inner']");
    public By CALENDAR_NEXT = By.cssSelector("[data-bui-ref='calendar-next']");
    public By MONTH = By.xpath("(//div[@class='bui-calendar__month'])[2]");
    public By SEARCH_BUTTON = By.cssSelector("[class='sb-searchbox__button ']");


    public void inputDestination() {
        getElement(SEARCH_CITY_LOCATOR).sendKeys(DESTINATION);
    }

    public void clickOnDates() {
        getElement(DATES).click();
    }

    public void clickOnCalendarNext() {
        getElement(CALENDAR_NEXT).click();
    }

    public boolean checkIfMonthIsDecember(){
        waitVisibility(MONTH);
        String month = getElement(MONTH).getText();
        return !Objects.equals(month, monthActual);
    }

    public void selectDay(By elementBy) {
        getElement(elementBy).click();
    }

    public void clickSearchButton() {
        getElement(SEARCH_BUTTON).click();
    }

    public void performSearch() {
        this.inputDestination();
        this.clickOnDates();
        while (this.checkIfMonthIsDecember()) {
            this.clickOnCalendarNext();
        }
        this.selectDay(By.cssSelector(SIGN_IN));
        this.selectDay(By.cssSelector(SIGN_OUT));
        this.clickSearchButton();
    }
}
