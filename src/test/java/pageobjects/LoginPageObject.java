package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import test.automation.framework.config.ConfigReader;
import test.automation.framework.pageobject.PageObject;

public class LoginPageObject extends PageObject {

    @Override
    public void navigateTo() {
        browser.get(ConfigReader.getInstance().getHost());
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    public void login(String email,String pass) throws InterruptedException {
        Actions action = new Actions(browser);
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", browser.getTitle());
        Thread.sleep(2000);
        browser.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/a[2]")).click();
        Thread.sleep(2000);
        Assert.assertEquals("Amazon Sign-In", browser.getTitle());
        Thread.sleep(2000);
        browser.findElement(By.id("ap_email")).sendKeys(email);
        Thread.sleep(2000);
        browser.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        browser.findElement(By.id("ap_password")).sendKeys(pass);
        Thread.sleep(2000);
        browser.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);
    }
}
