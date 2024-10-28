package loginDemo;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class LoginTest {
	WebDriver w;
	
  @Test(dataProvider = "dp")
  public void LoginTest(String un,String pw) {
	  
	  
	  w.get("https://testffc.nimapinfotech.com/");
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//code forlogin
		w.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).clear();
		w.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(un.toString());
		w.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).clear();
		w.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys(pw.toString());
		
		w.findElement(By.id("kt_login_signin_submit")).click();
		
		//code for alert popup
		w.findElement(By.xpath("/html/body/kt-base/div[2]/div/div/kt-header/div/kt-topbar/div/kt-user-punch/div/div[2]/button/span[1]")).click();
		Alert alert1=w.switchTo().alert();
		alert1.accept();
		
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] {"nirajshah0709@gmail.com" , "07091995@Ns"},
		new Object[] {"shahniraj548@gmail.com" , "07091995@Ns"},
		new Object[] {"snehalpatlin@gmail.com" , "07091995@Ns"},
  };
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Nirajshah\\Login\\chromedriver.exe");	
		w=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	 
  }

}
