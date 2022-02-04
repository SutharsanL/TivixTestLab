package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.HooksImplement;
import intializer.PropInitializer;

public class CarDetailsPage extends PropInitializer {
	static	WebDriver driver;
	public CarDetailsPage(WebDriver drive) {
		// TODO Auto-generated constructor stub
		this.driver=drive;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//div[@class='card-header']")
	WebElement carModel;
	
	@FindBy(xpath = "//h6[contains(text(),'Pickup date')]")
	WebElement pickupDate;
	
	@FindBy(xpath = "//p[contains(text(),'Location')]")
	WebElement location;
	
	@FindBy(xpath = "//a[text()='Rent!']")
	WebElement rentbutton;
	
	public void validateCarDetails() {
		Assert.assertEquals(true,carModel.getText().contains(prop.getProperty("Model")));
		System.out.println("car model:"+carModel.isDisplayed() );
		Assert.assertEquals(true,pickupDate.getText().contains(HooksImplement.nextDate("yyyy-MM-dd")));
		System.out.println("date: "+pickupDate.getText().contains(HooksImplement.nextDate("yyyy-MM-dd")));
		Assert.assertEquals(true,location.getText().contains(prop.getProperty("Country")));
		System.out.println("Location: "+location.getText().contains(prop.getProperty("Country")));
	}
	
	public void clickrentbutton() {
		rentbutton.click();
	}
	
}
