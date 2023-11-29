package TestCase;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ATest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
    }
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with a blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login("", Constant.PASSWORD).getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD + "0").getErrorMessage();

    }

    @Test
    public void TC04(){
        System.out.println("TC03 - Login page displays instead of Book ticket page");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoBookTicketPage();
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

    }

    @Test
    public void TC05(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i = 1; i < 6; i++){
            String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD + "0").getErrorMessage();
        }
    }

    @Test
    public void TC06(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        MyTicketPage bookTicketPage = homePage.gotoMyticketPage();

        boolean headerpost1 = Constant.WEBDRIVER.findElement(By.xpath("//h1[normalize-space()='Manage ticket']")).isDisplayed();
        if (headerpost1 == true) {
            System.out.println("This is Myticket Page");
        } else {
            System.out.println("This not is My ticket Page");
        }
        // Click "Chane password"
        ChangePasswordPage changePasswordPage = homePage.gotoChangePassWordPage();

        boolean headerpost2 = Constant.WEBDRIVER.findElement(By.xpath("//h1[normalize-space()='Change password']")).isDisplayed();
        if (headerpost2 == true) {
            System.out.println("This is ChangePassword Page");
        } else {
            System.out.println("This not is ChangePassword Page");

        }

    }

    @Test
    public void TC07(){
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String actualMsg = registerPage.regis(Constant.USERNAME,Constant.PASSWORD,Constant.PASSWORD,Constant.PID).getLblRegisMsg().getText();
    }

    @Test
    public void TC08(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, "11223344").getErrorMessage();
    }

    @Test
    public void TC09(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        ChangePasswordPage changePasswordPage = homePage.gotoChangePassWordPage();
        String actualMsg2 = changePasswordPage.changePassword(Constant.PASSWORD,Constant.PASSWORD,Constant.PASSWORD).getlblMessageChange().getText();
    }

    @Test
    public void TC10(){
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String actualMsg = registerPage.regis(Constant.USERNAME,Constant.PASSWORD,"11223344",Constant.PID).getLblRegisMsg().getText();
    }

    @Test
    public void TC11(){
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();
        String actualMsg = registerPage.regis(Constant.USERNAME,"","","").getLblRegisMsg().getText();
        String actualMsg1 = registerPage.regis(Constant.USERNAME,"","","").getLblpasswordlenght().getText();
        String actualMsg2 = registerPage.regis(Constant.USERNAME,"","","").getLblpidlenght().getText();

    }

    @Test
    public void TC12(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        ForgotPage forgotPage = loginPage.gotoForgotPage();
        forgotPage.sendinstructions(Constant.USERNAME);
    }

    @Test
    public void TC13(){

    }




    @Test
    public  void TC14(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        String message= bookTicketPage.bookticket(3,0,1,5,0).getlblbook().getText();
    }

    @Test
    public void TC15(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        TimeTablePage timeTablePage = homePage.gotoTimtablePage();
        timeTablePage.clickTicket();
    }

    @Test
    public void TC16(){
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        MyTicketPage myTicketPage = homePage.gotoMyticketPage();
        myTicketPage.cancelticket();
    }

}
