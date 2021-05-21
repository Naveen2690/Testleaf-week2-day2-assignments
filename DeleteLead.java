package  week2.day2.Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//span[@class=\"x-tab-strip-inner\"]/span)[2]").click();
		driver.findElementByName("phoneNumber").sendKeys("44225186");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(5000);
		WebElement firstID=driver.findElementByXPath("(//a[@class='linktext'])[4]");
		String Fid=firstID.getText();
		System.out.println(Fid);
		firstID.click();
		driver.findElementByClassName("subMenuButtonDangerous").click();
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='x-form-element']/input)[13]").sendKeys(Fid);
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(3000);
		String verify=driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		System.out.println(verify); 
		if (verify.contains("No records to display")) {
			System.out.println("Lead deleted successfully");
		}
		else {
			System.out.println("lead not deleted");
		}
		driver.close();
	}
}