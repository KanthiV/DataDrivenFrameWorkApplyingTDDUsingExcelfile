package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {

	WebDriver driver;
	
  public DashBoardPage(WebDriver driver) {
	this.driver = driver; 
 
  }
  
  // Element Library
  
  @FindBy (how = How.XPATH, using = " //h2[contains(text(), ' Dashboard ')]") WebElement DASHBOARD_BUTTON_ELEMENT;
  
   public void varifyDashBoardElement() {
	   String dashBoardElementValidation = DASHBOARD_BUTTON_ELEMENT.getText(); 
	   Assert.assertEquals(dashBoardElementValidation, "Dashboard", "Wrong Page!" );
   
   }

}
