package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final By _txtEmail = By.xpath("//*[@id=\"email\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _txtConfirmPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private final By _txtPassport = By.xpath("//*[@id=\"pid\"]");
    private final By _btnRegis = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/p/input");
    private final By _lblRegisErrorMsg = By.xpath("//*[@id=\"content\"]/p[2]");
    private final By _lblInvalidpasswordlenght = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[2]/label[2]");
    private final By _lblInvalidpidlenght = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[4]/label[2]");

    //Element
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPid(){
        return Constant.WEBDRIVER.findElement(_txtPassport);
    }
    public WebElement getBtnRegis(){
        return Constant.WEBDRIVER.findElement(_btnRegis);
    }
    public WebElement getLblRegisMsg(){
        return Constant.WEBDRIVER.findElement(_lblRegisErrorMsg);
    }
    public WebElement getLblpasswordlenght(){
        return Constant.WEBDRIVER.findElement(_lblInvalidpasswordlenght);
    }
    public WebElement getLblpidlenght(){
        return Constant.WEBDRIVER.findElement(_lblInvalidpidlenght);
    }
    //Method
    public RegisterPage regis(String email, String password,  String confirmpassword,  String pid){
        this.getTxtUsername().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegis().click();
        return new RegisterPage();
    }
}
