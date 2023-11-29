package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    private final By _txtCurrentPassword = By.xpath("//*[@id=\"currentPassword\"]");
    private final By _txtNewPassword = By.xpath("//*[@id=\"newPassword\"]");
    private final By _txtConfirmNewPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private final By _btnChange = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p/input");
    private final By _lblMessage = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");

    public WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getTxtConfirmNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmNewPassword);
    }
    public WebElement getbtnChange() {return Constant.WEBDRIVER.findElement(_btnChange);}
    public  WebElement getlblMessageChange(){return Constant.WEBDRIVER.findElement(_lblMessage);}

    public ChangePasswordPage changePassword(String currentpass, String newpass, String confirmnewpass){
        this.getTxtCurrentPassword().sendKeys(currentpass);
        this.getTxtNewPassword().sendKeys(newpass);
        this.getTxtConfirmNewPassword().sendKeys(confirmnewpass);
        this.getbtnChange().click();
        return new ChangePasswordPage();
    }
}
