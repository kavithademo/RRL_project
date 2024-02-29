package Stepdeifinition;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelData.ExcelDataReader;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;


import Pages.Manage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageStepdefinition {
	
	public static WebDriver driver;
	Manage app;
	private static Logger logger=LogManager.getLogger(ManageStepdefinition.class);
	
	
	
	@Given("Browser is open")
	public void browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    app=new Manage(driver);
	}

	
	@Given("Browser is on the login page")
	public void browser_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		app.navigateToUrl("https://demo.openmrs.org/openmrs/login.htm");
		logger.info("+login page");
		
	}



	@When("i enter username and password")
	public void i_enter_username_and_password() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		app.enterUsername("admin");
		logger.info("+username");
		
		Thread.sleep(1000);
		
	    app.enterPassword("Admin123");
	    logger.info("+password");
	}

	@When("i click on impatient ward to access location")
	public void i_click_on_impatient_ward_to_access_location() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		app.selectLocator();
		logger.info("+locator");
	    Thread.sleep(1000);
	    app.loginbutton();
	    logger.info("+loginbutton");
	}

	@Then("i navigate to homepage")
	public void i_navigate_to_homepage() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		app.navigateToAppoinmentScheduling();
		logger.info("+appoinmentscheduling");
		app.navigateToManageAppoinments();
		logger.info("+manageappoinments");
	
		Thread.sleep(1000);
		app.patientSearch();
		logger.info("+searchpatient");
		Thread.sleep(3000);
		app.SearchResult();
		logger.info("+Result");
		Thread.sleep(3000);
		takeScreenShot("patient-appoinments.png");
		assertTrue(false);
		assertFalse(true);
	}
		//assertEquals("patientsearch", "patientresult");
		//assertNotEquals("patientsearch", "patientresult");
		
		public static void takeScreenShot(String fileName) {
			// 1. type cast driver instance too take screen shot
			TakesScreenshot tsc = (TakesScreenshot) driver ;
			
			// 2. call take screen shot method with file type
			File src = tsc.getScreenshotAs(OutputType.FILE);
			
			// 3. create  file  with screen shot
			try {
				FileHandler.copy(src, new File("screenshot-output\\"+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	
		
	
	    	//driver.quit();
	 
	    
	private void takeScreenShot() {
		// TODO Auto-generated method stub
		
	}


	@DataProvider(name = "loginData")
    public Iterator<Object[]> getTestData() throws IOException {
        String filePath = "C:\\Users\\uppar\\cucumber workspace\\RRL_Project\\src\\test\\resources\\Testdata.xlsx";
        String sheetName = "Sheet1";
        List testData = (List) ExcelDataReader.readTestData(filePath, sheetName);
        java.util.List<Object[]> testData2 = (java.util.List<Object[]>) testData;
		java.util.List<Object[]> list = testData2;
		return list.iterator();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        
        System.out.println("Username: " + username + ", Password: " + password);
    }
	   
	
	 


   @Given("website is opened")
   public void website_is_opened() {
    // Write code here that turns the phrase above into concrete actions
	driver=new ChromeDriver();
    driver.manage().window().maximize();
    app=new Manage(driver);
}

     @Given("naviagate to login page")
   public void naviagate_to_login_page() {
    // Write code here that turns the phrase above into concrete actions
	 // Write code here that turns the phrase above into concrete actions
	app.navigateToUrl("https://demo.openmrs.org/openmrs/login.htm");
	logger.info("+login page");
}

   @When("user enter username and password")
  public void user_enter_username_and_password() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	app.enterUsername("admin");
	logger.info("+username");
	
	Thread.sleep(1000);
	
    app.enterPassword("Admin123");
    logger.info("+password");
}

   @When("user click on impatient ward to access location")
   public void user_click_on_impatient_ward_to_access_location() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	app.selectLocator();
	logger.info("+locator");
    Thread.sleep(1000);
    app.loginbutton();
    logger.info("+loginbutton");
}

   @Then("user navigate to homepage")
public void user_navigate_to_homepage() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	app.navigateToAppoinmentScheduling();
	logger.info("+appoinmentscheduling");
	app.navigateToManageAppoinments();
	logger.info("+manageappoinments");

	Thread.sleep(1000);
	app.patientSearch();
	logger.info("+searchpatient");
	Thread.sleep(3000);
	app.SearchResult();
	logger.info("+Result");
	Thread.sleep(3000);
	assertFalse(false);
	
	driver.quit();
}
}


