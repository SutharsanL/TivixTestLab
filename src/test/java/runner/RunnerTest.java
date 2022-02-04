package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)

@CucumberOptions(
		
features="src\\test\\resources\\features"
,glue={"stepDefinations","hooks"}
,monochrome= true
,publish = true
,plugin={"pretty","json:target/JsonReports/cucumberjsonreport.json",
		"html:target/HtmlReports/cucumberhtmlreport.html"})
public class RunnerTest {
	
@AfterClass

	
	public static void generateReport(){
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File cucumberReports=	new File(System.getProperty("user.dir")+"\\target\\JsonReports\\cucumberjsonreport.json");
		
		File cucumberReportsHistory=	new File(System.getProperty("user.dir")+"\\target\\JsonReports\\cucumberjsonreport_"+timestamp+".json");
		
		cucumberReports.renameTo(cucumberReportsHistory);
		
		
		File dir = new File(System.getProperty("user.dir")+"\\target\\JsonReports\\");
		
		File[] files= dir.listFiles((dir1, name) -> name.startsWith("cucumberjsonreport")&& name.endsWith(".json"));
		
		if(files!=null){
		Collection<File>	jsonFiles =Arrays.asList(files);
	
		List<String> jsonpaths = new ArrayList<>(jsonFiles.size());
		
		for(File file: jsonFiles){
			jsonpaths.add(file.getAbsolutePath());
		}
		
		Configuration config =new Configuration(new File("target"), "CucumberBDDMultipleData");
		
		config.addClassifications("PLATFORM", "Windows");
		config.addClassifications("BROWSER", "Chrome");
		
			
		ReportBuilder reportbuilder = new ReportBuilder(jsonpaths, config);
		reportbuilder.generateReports();
		}
	}

}
