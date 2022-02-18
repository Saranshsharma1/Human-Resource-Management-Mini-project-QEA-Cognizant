package Pages;
//importing all the required packages
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.Base;

public class Orange extends Base{
    public void OpenUrl(){
		// getting the url
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	//To search for the details and login into the page
	public void search() throws InterruptedException{
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		if(driver.getCurrentUrl().contains("dashboard")) 
			System.out.println("Valid URL");
		else
			System.out.println("Invalid URL");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"))).perform();
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.id("menu_admin_Job"))).perform();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		List<WebElement> jobs = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a"));
    	for(int i=0;i<jobs.size();i++){
			System.out.println(jobs.get(i).getText());
		}
		System.out.println("It doesn't contain Automation Tester.");
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Automation Tester");
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Automation Tester is added.");
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	public static void main(String[] args) throws InterruptedException{
		// implementing code
		Orange ha= new Orange();
		ha.driverSetup();
		ha.OpenUrl();
		ha.search();
		ha.closeBrowser();
	}
}
