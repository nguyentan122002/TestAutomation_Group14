package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage {
    private final By departdate = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[1]/select");
    private final By departfrom = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select");
    private final By departarrive = By.xpath("//*[@id=\"ArriveStation\"]/select");
    private final By departtype = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[4]/select");
    private final By departamount = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[5]/select");

    private final By btnBook = By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/input");
    private final By lblbookSuccess = By.xpath("//*[@id=\"content\"]/h1");
    public WebElement getdepartdate(){
        return Constant.WEBDRIVER.findElement(departdate);
    }
    public WebElement getdepartfrom(){
        return Constant.WEBDRIVER.findElement(departfrom);
    }
    public WebElement getdepartarrive(){
        return Constant.WEBDRIVER.findElement(departarrive);
    }
    public WebElement getdeparttype(){
        return Constant.WEBDRIVER.findElement(departtype);
    }
    public WebElement getdepartamount(){
        return Constant.WEBDRIVER.findElement(departamount);
    }

    public WebElement getbtnBook(){
        return Constant.WEBDRIVER.findElement(btnBook);
    }

    public WebElement getlblbook(){return Constant.WEBDRIVER.findElement(lblbookSuccess);}

    public BookTicketPage bookticket(int date,int from, int arrive, int type, int amount){


        Select departdate =new Select(getdepartdate());
        departdate.selectByIndex(date);

        Select departfrom =new Select(getdepartfrom());
        departfrom.selectByIndex(from);

        Select departarrive =new Select(getdepartarrive());
        departarrive.selectByIndex(arrive);

        Select departtype =new Select(getdeparttype());
        departtype.selectByIndex(type);

        Select departamount =new Select(getdepartamount());
        departamount.selectByIndex(amount);

        this.getbtnBook().click();
        return new BookTicketPage();
    }


}
