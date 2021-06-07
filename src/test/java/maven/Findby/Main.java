package maven.Findby;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {

	private WebDriver driver;


@BeforeMethod()
public void beforeMethod()

{
	
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	driver.get("https://testzenlabs.ie/education-form/");
}

@Test(priority = 0)
public void Homepage() throws InterruptedException 

{
	
	HomePage login_page=PageFactory.initElements(driver, HomePage.class);
	
	login_page.Primary("primary_School");
	Thread.sleep(1000);
	login_page.Secondary("secondary_School");
	login_page.Intermediate("intermediate");
	login_page.Engineering("engineering");
	login_page.University("university");
	login_page.Gender("gender");
		
}


@AfterMethod()
public void aftermethod() {
	driver.quit();
}

}
