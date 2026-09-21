package day16;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class masterfile implements I {
	WebDriver driver;
	WebElement we_name, we_password, we_button;
	ExtentReports extentReports;
	ExtentTest extentTest;
	boolean status;
	@BeforeTest
	void Open_Browser()
	{
		extentReports= new ExtentReports(path + "Report.html");
		extentTest=extentReports.startTest("Demo");
		driver=new ChromeDriver();
		driver.get(base_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	void Enter_Data()
	{
		we_name=driver.findElement(user_name);
		we_name.sendKeys("Admin");
		we_password=driver.findElement(pass);
		we_password.sendKeys("admin123");
		we_button=driver.findElement(button_click);
		we_button.click();
		status=driver.getPageSource().contains("Dashboard");
		if(status==true)
		{
			extentTest.log(LogStatus.PASS,"Test case pass");
		}
		else
		{
			extentTest.log(LogStatus.FAIL,"Test case fail");
		}
	}
	@AfterTest
	void Closepage()
		{
			extentReports.endTest(extentTest);
			extentReports.flush();
			driver.close();
		}
	}
	
	


