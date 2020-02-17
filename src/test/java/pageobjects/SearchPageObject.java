package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import test.automation.framework.pageobject.PageObject;

public class SearchPageObject extends PageObject {

    @Override
    public void navigateTo() {

    }

    @Override
    public boolean isPresent() {
        return false;
    }

    public void searchProduct() throws InterruptedException {
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", browser.getTitle());
        Thread.sleep(2000);
        browser.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[3]/div[1]/input")).sendKeys("samsung");
        //click on submit button
        browser.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).click();
        Thread.sleep(2000);
        Assert.assertEquals("Amazon.com: samsung", browser.getTitle());
        //click on 2. pagination button
        browser.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[8]/div/span/div/div/ul/li[3]")).click();
        Thread.sleep(2000);
        //click on 3. result
        browser.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[4]/div[1]/div[3]/div/span/div/div/div[2]/div[1]/div/div/span/a")).click();
        Thread.sleep(2000);
    }


}
