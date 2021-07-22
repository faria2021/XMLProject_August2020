package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ADDCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	WebDriver driver;
	
//	String userName =null;
//	String password = null;
//	String fullName = null;
//	String companyName = null;
//	String email = null;
//	String phone = null;
//	String address = null;
//	String city = null;
//	String country = null;
//	String state = null;
//	String zip = null;
//	
			
	
	
	@Test
	@Parameters({"username","password","FullName","CompanyName","Email","phone","Address","City","Country","State","zip"})
	public void validUserShouldBeAbleToAddCustomer(String userName,String password, String fullName,String companyName,String email,String phone,String address,String city,String Country,String state,String zip) {
		driver =BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LoginPage.insertUserName(userName);
		LoginPage.insertPassword(password);
		LoginPage.clickOnSinginButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		ADDCustomerPage addCustomerPage = PageFactory.initElements(driver, ADDCustomerPage.class);
		addCustomerPage.insertUserName(fullName);
		
		addCustomerPage.insertCompanyName(companyName);
		
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		Object country = null;
		addCustomerPage.enterCountryName((String) country);
		addCustomerPage.clickSubmitButton();
		addCustomerPage.clickOnListCustomerButton();
		
		
		 
	}

}
