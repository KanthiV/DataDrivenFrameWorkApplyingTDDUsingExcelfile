package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
 
	WebDriver driver;
	
	ExcelReader reader = new ExcelReader(".\\data\\TF_TestData.xlsx");
	String username = reader.getCellData("LoginInfo", "UserName", 2);
	String password = reader.getCellData("LoginInfo", "Password", 2);
	
	String fullName = reader.getCellData("AddContactInfo", "FullName", 2 );
	String companyName =  reader.getCellData("AddContactInfo", "Company Name", 2);
	String email = reader.getCellData("AddContactInfo","Email", 2);
	String phoneNum = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	String group = reader.getCellData("AddContactInfo", "Group", 2) ;
    
	@Test
    public void ValidUserShouldBeAddCustomer() {
    	
    	driver = BrowserFactory.init();
    	
    	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
    	loginpage.enterUserName(username );
    	loginpage.enterPassword(password);
    	loginpage.clickSignInButton();
    	
    	DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
    	dashboardpage.varifyDashBoardElement();
    	
    	AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
    	addcustomerpage.clickCustomersButton();
    	addcustomerpage.clickAddcustomerButton();
    	addcustomerpage.enterFullName(fullName);
    	addcustomerpage.selectCompanyFromDropDown(companyName);
    	addcustomerpage.enterEmail(email);
    	addcustomerpage.enterPhoneNumber(phoneNum);
    	addcustomerpage.enterAddress(address);
    	addcustomerpage.enterCity(city);
    	addcustomerpage.enterState(state);
    	addcustomerpage.enterZip(zip);
    	addcustomerpage.selectGroupFromDropDown(group);
    	addcustomerpage.clickSaveButton();
    	addcustomerpage.clickListCustomerButton();
    	addcustomerpage.verifyEnteredCustomerAndDelete();
    	
    	
    	BrowserFactory.tearDown();
    	
    }


}
