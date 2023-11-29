package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPage {
    private final By _txtEmail = By.xpath("//*[@id=\"email\"]");
    private final By _btnSend = By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]/input");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getbtnSend(){
        return Constant.WEBDRIVER.findElement(_btnSend);
    }

    public ForgotPage sendinstructions(String email){
        this.getTxtEmail().sendKeys(email);
        this.getbtnSend().click();
        return new ForgotPage();
    }
}
