package pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.HooksImplement;
import intializer.PropInitializer;

public class SearchCarPage extends PropInitializer{
	static	WebDriver driver;
	public SearchCarPage(WebDriver drive) {
		// TODO Auto-generated constructor stub
		this.driver=drive;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "model")
	WebElement model;
	
	@FindBy(id = "pickup")
	WebElement pickupDate;
	
	@FindBy(id = "dropoff")
	WebElement dropoffDate;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchButton;
	
	@FindBy(id = "search-results")
	WebElement searchResult;
	
	@FindBy(xpath ="(//td[text()='Mazda 3']/following::a[text()='Rent'])[1]")
	WebElement Rentbtn;
	
	@FindBy(xpath ="//h3[text()='Please enter a valid date!']")
	WebElement errorMsg;
	
	public void selectCountry() throws IOException{
		System.out.println(prop.getProperty("Country"));
		HooksImplement.selectbyText(country, prop.getProperty("Country"));
		
	} 
	
	public void selectCity() throws IOException{
		HooksImplement.selectbyText(city, prop.getProperty("City"));	
	}
	
	public void enterModel() throws IOException{
		  model.sendKeys(prop.getProperty("Model"));	
	}
	
	public void selectPickupDate() throws IOException{
		  pickupDate.sendKeys(HooksImplement.nextDate("dd/MM/yyyy"));	
	}
	
	public void selectDropoffDate() throws IOException{
		  dropoffDate.sendKeys(HooksImplement.nextDate("dd/MM/yyyy"));	
	}
	
	public void clickSearch() throws IOException{
		  searchButton.click();
	}
	
	public void verifySearchResult() throws IOException{
		Assert.assertEquals(true, searchResult.isDisplayed());
		 
	}
	
	public void clickRentbtn() throws IOException{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Rentbtn);
		Rentbtn.click();
		 
	}
	public void selectInvalidDropoffDate() throws IOException{
		  pickupDate.sendKeys(HooksImplement.nextDate("dd/MM/yyyy"));
		  dropoffDate.sendKeys(HooksImplement.currentDate("dd/MM/yyyy"));	
	}
	
	public void validateErrorMsg() throws IOException{
		System.out.println(errorMsg.getText());
		Assert.assertEquals(true, errorMsg.isDisplayed());
		  	
	}
	
}
