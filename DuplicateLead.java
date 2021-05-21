package  week2.day2.Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	

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
		driver.findElementByXPath("//span[contains(text(),'Email')]").click();
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("hindu");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(5000);
		WebElement firstLead=driver.findElementByXPath("(//a[@class=\"linktext\"])[4]");
		System.out.println(firstLead.getText());
		firstLead.click();
		String firstlname=driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(firstlname);
		driver.findElementByXPath("//a[contains(text(),\"Duplicate Lead\")]").click();
		String dup=driver.getTitle();
		if(dup.contains("Duplicate Lead")) {
			System.out.println("verified");
		}
		else {
			System.out.println("not verified");
		}
		driver.findElementByXPath("//input[@value=\"Create Lead\"]").click();
		String first=driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println(first);
		if(firstlname.equals(first)) {
			System.out.println("Captured name and duplicate lead name are same");
		}
		else {
			System.out.println("Captured name and duplicate lead name are not same");
		}
		driver.close();
	}
}