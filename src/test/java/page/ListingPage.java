package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static page.constants.Constant.Const.DAYS_VALUE;
import static page.constants.Constant.Const.DESTINATION;

public class ListingPage extends Main{

    public ListingPage(WebDriver driver) {
        super(driver);
    }

    public By WEB_ELEMENTS_WITH_CITY = By.cssSelector("[data-testid='address']");
    public By WEB_ELEMENTS_WITH_DAYS = By.cssSelector("[data-testid='price-for-x-nights']");
    public By NUMBER_OF_RESULTS_HEADER = By.cssSelector("[class='e1f827110f d3a14d00da']");
    public By NUMBER_OF_RESULTS_FOOTER = By.className("d8f77e681c");

    public void verifyCityInSearch() {
        verifySearchList(WEB_ELEMENTS_WITH_CITY, DESTINATION);
    }

    public void verifyNumberOfDays() {
        verifySearchList(WEB_ELEMENTS_WITH_DAYS, DAYS_VALUE) ;
    }

    public String getElementText(By elementBy) {
        getElement(elementBy).getText();
        return null;
    }

    public void verifySearchResults() {
        this.verifyCityInSearch();
        this.verifyNumberOfDays();
    }

    public void verifyNumberOfResults() {
        String header = getElementText(NUMBER_OF_RESULTS_HEADER);
        String footer = getElementText(NUMBER_OF_RESULTS_FOOTER);
        Assertions.assertEquals(header, footer);
    }
}
