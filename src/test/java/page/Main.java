package page;

import org.openqa.selenium.WebDriver;

import static page.constants.Constant.Const.TEST_URL;

public class Main extends PageBase {


    public Main(WebDriver driver) {
        super(driver);
    }

    public void goTo(){
        driver.get(TEST_URL);
    }

    public void goToPage() {
        this.goTo();
    }



}
