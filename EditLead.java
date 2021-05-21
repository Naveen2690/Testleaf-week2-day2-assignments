package  week2.day2.Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		    
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("naveen");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(3000);
		WebElement firstLead=driver.findElementByXPath("(//a[@class=\"linktext\"])[4]");
		firstLead.click();
		String view=driver.getTitle();
		if(view.contains("View Lead")) {
			System.out.println("verified");
		}
		else {
			System.out.println("not verified");
		}
		Thread.sleep(3000);

		driver.findElementByXPath("//a[contains(text(),'Edit')]").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("mintra");
		driver.findElementByXPath("//input[@value=\"Update\"]").click();
		driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(driver.findElementById("viewLead_companyName_sp").getText());
		driver.close();
	}
}