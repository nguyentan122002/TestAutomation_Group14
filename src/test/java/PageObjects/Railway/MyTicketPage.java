package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.*;

public class MyTicketPage {
    private final By _btnCancel = By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[11]/input");
    private final By _manageticket = By.xpath("//h1[normalize-space()='Manage ticket']");
    public WebElement getbtnCancel(){return Constant.WEBDRIVER.findElement(_btnCancel);}
    public WebElement getmanageticket(){return Constant.WEBDRIVER.findElement(_manageticket);}

    public MyTicketPage cancelticket(){
        this.getmanageticket().click();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();",getmanageticket());
        this.getbtnCancel().click();
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
        return new MyTicketPage();
    }
}
