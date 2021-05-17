package week2.day2.Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("Naveen");
		driver.findElementById("lastNameField").sendKeys("Kumar");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Naveen");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Kumar");
		driver.findElementByName("departmentName").sendKeys("Medical");
		driver.findElementById("createContactForm_description").sendKeys("this is related to medicine");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("naveenkumarng8197@gmail.com");
		WebElement state=driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select statepro=new Select(state);
		statepro.selectByVisibleText("New York");
		driver.findElementByClassName("smallSubmit").click();
		driver.findElementByXPath("//a[contains(text(),'Edit')]").click();
		driver.findElementByXPath("//textarea[@name='description']").clear();
		driver.findElementByName("importantNote").sendKeys("abcdef");
		driver.findElementByXPath("//input[@value='Update']").click();
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}