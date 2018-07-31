import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CssXpathEg {

	public static void main(String[] args) {
		//setting up firefox geckodriver path
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe"); 
		//create new instance of FireFoxDriver
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.co.in"); 
		//find element by CSS selector
		//WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
		WebElement element = driver.findElement(By.xpath("//*[@id='lst-ib']"));
		 //enter the text
		element.sendKeys("cake");
		//submit the form. Webdriver will find form and submit
		element.submit();
		//check title of page
		System.out.println("Page title is: "+ driver.getTitle());
		
        // Wait for the page to load, timeout after 10 seconds
		WebDriverWait webWait=new WebDriverWait(driver, 10);
		webWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cake");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();

	}

}
