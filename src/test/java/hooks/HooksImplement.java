package hooks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import java.time.LocalDate;
import java.time.LocalDateTime; 
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import intializer.PropInitializer;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HooksImplement {

	public  WebDriver driver;
@Before
public void driverInitialize() throws IOException{
	WebDriverManager.chromedriver().setup();
	if(driver==null){
	 driver = new ChromeDriver();
	 driver.get("http://qalab.pl.tivixlabs.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 PropInitializer.initialize();
	}
	
	
}
	public static void selectbyText(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static String nextDate(String format) {
		String nDate=""; 
		   LocalDate cdate = LocalDate.now().plusDays(1);  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		   nDate= cdate.format(dtf);
		return nDate;
		
	}
	
	public static String currentDate(String format) {
		String currentDate=""; 
		   LocalDate cdate = LocalDate.now();  
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		   currentDate= cdate.format(dtf);
		return currentDate;
		
	}
	
@AfterStep
public void tearDown(Scenario s) throws IOException{
		Screenshot img =new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
     ImageIO.write(img.getImage(), "png",  baos);
     byte[] bytes = baos.toByteArray();	
	s.attach(bytes, "image/png", "image");
	
	
}


@After
public void closeDriver(){
	driver.quit();
}


}


