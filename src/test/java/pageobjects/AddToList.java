package pageobjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import test.automation.framework.pageobject.PageObject;
import org.openqa.selenium.WebElement;


public class AddToList extends PageObject {
    private WebDriver driver;
    @Override
    public void navigateTo() {
    }

    @Override
    public boolean isPresent() {

        return false;
    }


    public void list() throws InterruptedException {

        browser.findElement(By.id("add-to-wishlist-button-submit")).isDisplayed();
        Thread.sleep(2000);
        browser.findElement(By.id("add-to-wishlist-button-submit")).click();

            //if wishlist create popup is displayed
            if(browser.findElements(By.id("WLNEW_list_type_WL")).size()>0)
            {

                Thread.sleep(2000);
                //select wishlist option
                browser.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/div/span/div/label/span")).click();
                //create list button
                browser.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/span[3]/span")).click();
                Thread.sleep(2000);
                //x button of the item added popup
                browser.findElement(By.xpath("/html/body/div[6]/div/div/header/button")).click();
                Thread.sleep(2000);
            }


        // if the item is or already added to the list
             else if(browser.findElements(By.xpath("/html/body/div[6]/div/div/div/div[2]/div[1]/div[2]/div/span[4]")).size()>0)
            {
                 //click on continue shopping button on the popup
                 browser.findElement(By.id("WLHUC_continue")).click();
                 Thread.sleep(2000);
            }
        Thread.sleep(2000);
        Actions action = new Actions(browser);
        WebElement we = browser.findElement(By.id("nav-link-accountList"));
        action.moveToElement(we).moveToElement(browser.findElement(By.linkText("Wish List"))).click().build().perform();
        Thread.sleep(5000);
        //click on delete button of first item of the list
        browser.findElements(By.id("g-items")).get(0).findElement(By.linkText("Delete item")).click();
        Thread.sleep(5000);
        Assert.assertEquals("deleted", browser.findElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/div[7]/div[3]/div/ul/li[1]/span/div/div[2]/div")).size()>0);



    }
}
