package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
 
	// Element library
	
	@FindBy (how = How.ID, using = "username") WebElement USERNAME_ELEMENT;
	@FindBy (how = How.ID, using = "password") WebElement PASSWORD_ELEMENT;
	@FindBy (how = How.NAME, using = "login") WebElement SIGNIN_BUTTON;

  public void enterUserName(String userName) {
	  USERNAME_ELEMENT.sendKeys(userName);  
	  
  }
  public void enterPassword(String password) {
	  PASSWORD_ELEMENT.sendKeys(password);  
	  
  }

  public void clickSignInButton() {
	  SIGNIN_BUTTON.click(); 
	 
  }

}
