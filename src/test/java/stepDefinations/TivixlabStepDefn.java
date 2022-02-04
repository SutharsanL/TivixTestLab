package stepDefinations;



import java.io.IOException;

import org.openqa.selenium.WebDriver;

import hooks.HooksImplement;
import intializer.PropInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarDetailsPage;
import pages.SearchCarPage;
import pages.SummaryPage;

public class TivixlabStepDefn extends PropInitializer{

	WebDriver driver ;
	SearchCarPage searchCar;
	CarDetailsPage carDetails;
	SummaryPage sumPage;
	public TivixlabStepDefn(HooksImplement hooks) {
		// TODO Auto-generated constructor stub
	this.driver=	hooks.driver;
	 searchCar=new SearchCarPage(driver);
	 carDetails=new CarDetailsPage(driver);
	 sumPage=new SummaryPage(driver);
	}


@Given("I want to Select Country")
public void i_want_to_select_country() throws IOException {
	//try {
		searchCar.selectCountry();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@When("I want to Select City")
public void i_want_to_select_city() throws IOException {
	//try {
		searchCar.selectCity();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@When("I want to enter the car model")
public void i_want_to_enter_the_car_model() throws IOException {
	//try {
		searchCar.enterModel();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@When("Select Pickup date and Dropoff date")
public void select_pickup_date_and_dropoff_date() throws IOException {
	//try {
		searchCar.selectPickupDate();
		searchCar.selectDropoffDate();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
}

@When("I click on Search button")
public void i_click_on_search_button() throws IOException {
	//try {
		searchCar.clickSearch();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Then("I validate wheather rental cars were displayed")
public void i_validate_wheather_rental_cars_were_displayed() throws IOException {
	//try {
		searchCar.verifySearchResult();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
}

@When("I Click on Rent button")
public void i_click_on_rent_button() throws IOException {
	//try {
		searchCar.clickRentbtn();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Then("I Validate the Car details")
public void i_validate_the_car_details() {
	//try {
		carDetails.validateCarDetails();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Then("Click on Rent button in car Details Page")
public void click_on_rent_button_in_car_details_page() {
	//try {
		carDetails.clickrentbutton();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Given("I want to enter valid Data")
public void i_want_to_enter_valid_Data() throws IOException {
	//try {
		sumPage.enterFnameAndLname(prop.getProperty("Fname"),prop.getProperty("Lname"));
		sumPage.enterCardNum(prop.getProperty("CardNumber"));
		sumPage.enterEMail(prop.getProperty("mail"));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Given("I want to enter invalid Data")
public void i_want_to_enter_invalid_Data() throws IOException {
	//try {
		sumPage.enterFnameAndLname(prop.getProperty("Fname"),prop.getProperty("Lname"));
		sumPage.enterCardNum(prop.getProperty("InValidCardNumber"));
		sumPage.enterEMail(prop.getProperty("InValidmail"));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@When("I click Rent button in Summarypage")
public void i_click_rent_button_in_summarypage() throws IOException {
//	try {
		sumPage.clicksumRentBtn();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Then("I vaildate whether application is working as expected")
public void i_vaildate_whether_application_is_working_as_expected() throws IOException {
	//try {
		sumPage.validateRentApp();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

@Then("I vaildate the error message")
public void i_vaildate_the_error_message() {
	try {
		sumPage.validateErrormsg();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("I want to select valid pickup and invalid dropoff date")
public void i_want_to_select_invaliddropoff_date() {
	try {
		searchCar.selectInvalidDropoffDate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("I Validate the error message for dropdate")
public void i_vaildate_the_error_message_for_dropdate() {
	try {
		searchCar.validateErrorMsg();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
