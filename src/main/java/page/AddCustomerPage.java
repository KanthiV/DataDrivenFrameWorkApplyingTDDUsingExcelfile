package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

  WebDriver driver;
  
  public AddCustomerPage(WebDriver driver) {
	  
	  this.driver = driver;
  }

   // Element Library
    @FindBy (how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMERS_BUTTON_ELEMENT;
   // @FindBy (how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADDCUSTOMER_BUTTON_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='account']") WebElement FULLNAME_ELEMENT;
    @FindBy (how = How.XPATH, using = "//select[@id='cid']") WebElement COMPANY_DROPDOWN_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='email']") WebElement EMAIL_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='city']") WebElement CITY_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='state']") WebElement STATE_ELEMENT;
    @FindBy (how = How.XPATH, using = "//input[@id='zip']") WebElement ZIP_ELEMENT;
    @FindBy (how = How.XPATH, using = "//select[@id='group']") WebElement GROUP_DROPDOWN_ELEMENT;
    @FindBy (how = How.XPATH, using = "//button[@id='submit']") WebElement SAVE_BUTTON_ELEMENT;
    
    @FindBy (how = How.XPATH, using = "//a[@id='summary']") WebElement SUMMARY_BUTTON_ELEMENT;
    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement LISTCUSTOMER_BUTTON;
  
  
   public void clickCustomersButton() {
	  // waitForElement(driver, 5, By.xpath("//span[contains(text(), 'Customers')]"));
	   CUSTOMERS_BUTTON_ELEMENT.click();
   
   }
   public void clickAddcustomerButton() {
	  // waitForElement(driver, 5, By.xpath("//a[contains(text(), 'Add Customer')]"));
	  // ADDCUSTOMER_BUTTON_ELEMENT.click();
      
	  driver.get("http://www.techfios.com/ibilling/?ng=contacts/add/");
   
   }
   
   String enteredFullName;
   public void enterFullName(String fullName) {
	 // enteredFullName = fullName + BasePage.randomNumGenerator();
	  
	  enteredFullName = fullName + randomNumGenerator();
	  FULLNAME_ELEMENT.sendKeys(enteredFullName );
	   
	 
   }
   public void selectCompanyFromDropDown(String company) {
	   // BasePage.dropDown(COMPANY_DROPDOWN_ELEMENT, company);
	   
	   dropDown(COMPANY_DROPDOWN_ELEMENT, company);
  
    }
   public void enterEmail(String email) {
	   String enteredEmail = randomNumGenerator() + email;
	   EMAIL_ELEMENT.sendKeys(enteredEmail );
	   
   }
   public void enterPhoneNumber(String phoneNum) {
	   String EnteredPhoneNum = randomNumGenerator() + phoneNum;
	   PHONE_ELEMENT.sendKeys(EnteredPhoneNum);
   }
   public void enterAddress(String address) {
	  ADDRESS_ELEMENT.sendKeys(address);
   
   }
   public void enterCity(String city) {
	  CITY_ELEMENT.sendKeys(city);
   
   }
   public void enterState(String state) {
	   STATE_ELEMENT.sendKeys(state);
   
   }
   public void enterZip(String zip) {
	   ZIP_ELEMENT.sendKeys(zip); 
	  
   }
   public void selectGroupFromDropDown(String group) {
	   dropDown(GROUP_DROPDOWN_ELEMENT, group);
   
   }
   public void clickSaveButton() {
	   SAVE_BUTTON_ELEMENT.click();
	   waitForElement(driver, 10, By.xpath("//a[@id='summary']"));//  after clicking 'save' button, you go to different page.
   }                                                              //  In that page, there is a 'summary' button.  
   public void clickListCustomerButton() {                         // We are applying ExplicitWait for 'summary' button before clicking 'ListCustomer' button.
	   driver.get("http://www.techfios.com/ibilling/?ng=contacts/list/");
	  // LISTCUSTOMER_BUTTON.click();
   }


	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[i]/td[3]
	
   //tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]     -    Delete Button
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	
	public void verifyEnteredCustomerAndDelete() {
		
		for(int i = 1; i <= 5; i++) {	//tbody/tr[i]/td[3]
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			//Assert.assertEquals(name, enteredFullName, "Name does not match!!!");
			
			if(name.contains(enteredFullName)) {
				System.out.println("Entered name exists");
				driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[3]/following-sibling::td[4]/a[2]")).click();
				BasePage.waitForElement(driver, 2, By.xpath("/html/body/div[1]/div/div/div[2]/button[2]"));
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			}
			
			
		}
		
	}
	






}
