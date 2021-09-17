package backend_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class AddProduct extends DriverSetup {
	
	
	@Test
	public static void addProduct() throws InterruptedException {
		driver.get(baseUrl);
		
		//login
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		Thread.sleep(1000);

		email.sendKeys("superadmin@gmail.com");
		password.sendKeys("superadmin");
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.className("btn-primary"));
		login.click();
		Thread.sleep(1000);
		
		// add product 
		WebElement catalogue = driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[3]/a"));
		catalogue.click();
		Thread.sleep(1000);
		
		WebElement products = driver.findElement(By.xpath("//a[@href='http://18.209.122.163/admin/product']"));
		products.click();
		Thread.sleep(1000);
		
		WebElement add_products = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[1]/div[1]/div/a"));
		add_products.click();
		Thread.sleep(1000);
		
		WebElement product_type = driver.findElement(By.name("product_type"));
		
		Select scl = new Select(product_type);
		scl.selectByValue("normal");
		Thread.sleep(1000);
		
		WebElement product_name = driver.findElement(By.name("product_name"));
		product_name.sendKeys("Test Normal Product");
		
		WebElement product_code = driver.findElement(By.name("product_code"));
		product_code.sendKeys("PN4545");
		
		WebElement product_description = driver.findElement(By.xpath("//*[@id=\"quill-container\"]/div[1]"));
		product_description.sendKeys("This is demo product");
		
		WebElement product_classification = driver.findElement(By.xpath("//*[@id=\"tab_basic-info\"]/div/div[7]/div/div/div[1]/div[1]/div[2]/input"));
		product_classification.click();
		product_classification.sendKeys("Laptop");
		Thread.sleep(1000);
		product_classification.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement common = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div"));
		common.click();
		Thread.sleep(1000);
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement specificLoc = driver.findElement(By.xpath("//*[@id=\"tab_basic-info\"]/div/div[8]/label"));
		
		js.executeScript("arguments[0].scrollIntoView();", specificLoc);
		Thread.sleep(3000);
		
		WebElement product_categtory = driver.findElement(By.xpath("//*[@id=\"tab_basic-info\"]/div/div[8]/div/div/div[1]/div[1]/div"));
		product_categtory.click();
		product_categtory.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		

		
		WebElement common2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div"));
		common2.click();
		Thread.sleep(5000);
		
		WebElement save = driver.findElement(By.xpath("//*[@id=\"saveActions\"]/button[1]"));
		save.click();
		Thread.sleep(2000);
	}

}
