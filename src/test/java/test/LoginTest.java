package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
   
	WebDriver driver;
	
	ExcelReader reader = new ExcelReader(".\\data\\TF_TestData.xlsx");
	String username = reader.getCellData("LoginInfo", "UserName", 2);
	String password = reader.getCellData("LoginInfo", "Password", 2);
	
  @Test 
  public void ValidUserShoudBeLogin()  {
	 
	  driver = BrowserFactory.init();
	  
	  LoginPage loginpage = PageFactory.initElements(driver,  LoginPage.class );
	  loginpage.enterUserName(username);
	  loginpage.enterPassword(password);
	  loginpage.clickSignInButton();
	  
	  DashBoardPage dashBoard = PageFactory.initElements(driver, DashBoardPage.class );
	  dashBoard.varifyDashBoardElement();
	   
	  
	 
	   BrowserFactory.tearDown();
  
  }



}
