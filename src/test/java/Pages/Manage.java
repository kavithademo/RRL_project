package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage {

	private WebDriver driver;
	public Manage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
     @FindBy(xpath="//*[@id=\"username\"]")
     private  WebElement username;
     @FindBy(xpath="//*[@id=\"password\"]")
     private WebElement password;
     @FindBy(xpath="//*[@id=\"Inpatient Ward\"]")
     private WebElement locator;
     @FindBy(xpath="//*[@id=\"loginButton\"]")
     private WebElement loginbutton;
     @FindBy(xpath="//*[@id=\"appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension\"]")
     private WebElement appoinmentscheduling;
     @FindBy(xpath="//*[@id=\"appointmentschedulingui-manageAppointments-app\"]")
     private WebElement manageappoinments;
     @FindBy(xpath="//*[@id=\"patient-search\"]")
     private WebElement Searchforpatient;
     @FindBy(xpath="//*[@id=\"patient-search-results-table\"]/tbody")
     private  WebElement patientSearchResult;
     
     
     
     public void navigateToUrl(String Url) {
    	 driver.get(Url);
     }
     public void enterUsername(String Username) {
    	username.sendKeys(Username);
     }
     public void enterPassword(String Password) {
    	 password.sendKeys(Password);
     }
     public void selectLocator() {
    	locator.click();
     }
     public void loginbutton() {
    	 loginbutton.click();
    	 
     }
     public void navigateToAppoinmentScheduling() {
    	 appoinmentscheduling.click();
    	 
     }
     public void navigateToManageAppoinments() {
    	 manageappoinments.click();
     }
     public void patientSearch() {
    	 Searchforpatient.sendKeys("Jessica King");
    	

    	 }
     public void SearchResult() {
    	 patientSearchResult.click();
     }
    
    

   }
     
    