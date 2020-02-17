package tests;

import org.junit.Test;
import pageobjects.*;
import test.automation.framework.BaseWebAutomationTest;
import test.automation.framework.config.ConfigReader;

public class ChallengeTest extends BaseWebAutomationTest {

    private LoginPageObject loginPage;
    private SearchPageObject searchPage;
    private AddToList detail;

    public ChallengeTest() {
        loginPage = new LoginPageObject();
        searchPage = new SearchPageObject();
        detail= new AddToList();

    }

    @Test
    public void addFavoriteTest() throws InterruptedException {
        loginPage.navigateTo();
        loginPage.login(ConfigReader.getInstance().getEmail(),ConfigReader.getInstance().getPassword());
        searchPage.searchProduct();
        detail.list();

    }


}
