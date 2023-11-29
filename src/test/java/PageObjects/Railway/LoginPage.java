package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    //Locators
    private final By _txtUsername = By.xpath("//*[@id=\"username\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _btnLogin = By.xpath("//input[@type='submit']");
    private final By _lblLoginErrorMsg = By.xpath("//*[@id=\"content\"]/p");
    private final By _btnForgotpass = By.xpath("//*[@id=\"content\"]/ul/li[3]/a");

    //Element
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getLblLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }
    public WebElement getbtnForgot(){return Constant.WEBDRIVER.findElement(_btnForgotpass);}

    //Method
    public HomePage login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        return new HomePage();
    }

    public ForgotPage gotoForgotPage(){
        this.getbtnForgot().click();
        return new ForgotPage();
    }

}

