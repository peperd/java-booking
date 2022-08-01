package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.PageBase;

import java.io.IOException;

public class BookingSearchTest extends TestBase {
    // Verify that when user enters "New York" in search and selects dates  December 1, 2022 - December 30, 2022
    // webpage booking.com returns search results with exactly the same city and dates
    @Test
    public void VerifyDestinationCityAndNumberOfDaysInSearch(){
        landingPage.performSearch();
        listingPage.verifySearchResults();
    }

    // Verify that search results for properties found on header and footer of search page are equal
    @Test
    public void VerifyTotalNumberOfSearchResults() {
        landingPage.performSearch();
        listingPage.verifyNumberOfDays();
    }

    // Counts number of @Test Annotations and save them in Array in result.txt
    @AfterAll
    static void makeReportOnAnnotationTest() throws IOException {
         PageBase.reflectionOnTest();
    }
}
