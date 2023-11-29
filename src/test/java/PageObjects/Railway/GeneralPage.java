package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a");
    private final By tabLogout = By.xpath("//*[@id=\"menu\"]/ul/li[9]/a/span");
    private final By lblWelcomeMessage = By.xpath("//*[@id=\"content\"]/h1");
    private final By lblErrorMessage = By.xpath("//*[@id=\"content\"]/p[@class='message error LoginForm']");
    private final By tabBookTicket = By.xpath("//*[@id=\"menu\"]/ul/li[6]/a/span");
    private final By tabMyTicket = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a/span");
    private final By tabChangePassword = By.xpath("//*[@id=\"menu\"]/ul/li[8]/a/span");
    private final By tabRegister = By.xpath("//*[@id=\"menu\"]/ul/li[7]/a/span");
    private final By tabTimetable = By.xpath("//*[@id=\"menu\"]/ul/li[4]/a/span");
    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getlblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getlblErrorMessage(){return Constant.WEBDRIVER.findElement(lblErrorMessage);}

    protected WebElement gettabMyticket(){return Constant.WEBDRIVER.findElement(tabMyTicket);}
    protected WebElement gettabChangepassword(){return Constant.WEBDRIVER.findElement(tabChangePassword);}
    protected WebElement gettabRegister(){return Constant.WEBDRIVER.findElement(tabRegister);}
    protected WebElement gettabTimetable(){return Constant.WEBDRIVER.findElement(tabTimetable);}


    //Method
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }

    public String getErrorMessage(){
        return this.getlblErrorMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage(){
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }


    public MyTicketPage gotoMyticketPage(){
        this.gettabMyticket().click();
        return new MyTicketPage();
    }

    public ChangePasswordPage gotoChangePassWordPage(){
        this.gettabChangepassword().click();
        return new ChangePasswordPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.gettabRegister().click();
        return new RegisterPage();
    }

    public TimeTablePage gotoTimtablePage(){
        this.gettabTimetable().click();
        return new TimeTablePage();
    }
}

