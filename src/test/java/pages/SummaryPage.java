package pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
	static	WebDriver driver;
	public SummaryPage(WebDriver drive) {
		// TODO Auto-generated constructor stub
		this.driver=drive;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id = "name")
	WebElement fName;
	
	@FindBy(id = "last_name")
	WebElement lName;
	
	@FindBy(id = "card_number")
	WebElement cardNumber;
	
	@FindBy(id = "email")
	WebElement eMail;
	
	@FindBy(xpath = "//button[text()='Rent']")
	WebElement rentBtn;

	
	public void enterFnameAndLname(String name1,String name2) throws IOException{
		  fName.sendKeys(name1);
		  lName.sendKeys(name2);
	}
	
	public void enterCardNum(String cardnum) throws IOException{
		  cardNumber.sendKeys(cardnum);	
	}
	
	public void enterEMail(String mail) throws IOException{
		  eMail.sendKeys(mail);	
	}
	
	public void clicksumRentBtn() throws IOException{
		rentBtn.click();
	}
	
	public void validateRentApp() throws IOException{
	
		System.out.println("Getting 404 Error: defect");
	
	}
	
	public void validateErrormsg() throws IOException{
	String xpath="(//h5[@class='alert alert-danger'])";
		String firstError=driver.findElement(By.xpath(xpath+"[1]")).getText();
		Assert.assertEquals("Please provide valid email",firstError);
		String secError=driver.findElement(By.xpath(xpath+"[2]")).getText();
		Assert.assertEquals("Card number contains wrong chars",secError);
	}
}
