package testNGTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGWebsiteTest {	
		
		WebDriver driver = null; 
		
		//LOGIN
		@Test
		public void login() throws InterruptedException {			
			//Navigating to Registration page
			driver.findElement(By.className("login")).click();		
			//Register Formalities
			driver.findElement(By.id("email")).sendKeys("deekshashetty1098@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("abc123");	
			driver.findElement(By.id("SubmitLogin")).click();
		}
		
		//REGISTER
		@Test
		public void register() throws InterruptedException {
			//REGISTER
			//Navigating to Registration page
			driver.findElement(By.className("login")).click();		
			//Register Formalities
			driver.findElement(By.id("email_create")).sendKeys("deekshashetty1098@gmail.com");
			driver.findElement(By.id("SubmitCreate")).click();		
			//Filling up the registration Form		
			//Selecting Radio Button
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//Method used because the driver was looking for the element before the page loaded, hence an error was thrown 
			WebElement radio1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender2")));		
			radio1.click();		
			//Filling text boxes
			//WebElement textbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
			driver.findElement(By.id("customer_firstname")).sendKeys("Deeksha");
			driver.findElement(By.id("customer_lastname")).sendKeys("Shetty");
			driver.findElement(By.id("passwd")).sendKeys("abc123");
			//Selecting options from Dropdown
			Select drpDay = new Select(driver.findElement(By.name("days")));
			drpDay.selectByVisibleText("10  ");
			Select drpMonth = new Select(driver.findElement(By.name("months")));
			drpMonth.selectByVisibleText("August ");
			Select drpYear = new Select(driver.findElement(By.name("years")));
			drpYear.selectByVisibleText("1998  ");
			//Filling text boxes
			driver.findElement(By.id("company")).sendKeys("BNP Paribas");
			driver.findElement(By.id("address1")).sendKeys("Malad");
			driver.findElement(By.id("city")).sendKeys("Mumbai");
			//Selecting options from Dropdown
			Select drpState = new Select(driver.findElement(By.name("id_state")));
			drpState.selectByVisibleText("Montana");
			//Filling text boxes
			driver.findElement(By.id("postcode")).sendKeys("00000");
			driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
			driver.findElement(By.id("alias")).sendKeys("India");
			//Clicking on Register Button
			driver.findElement(By.id("submitAccount")).click();
		}
		
		//SEARCH
		@Test
		public void search() throws InterruptedException {			 
			//driver.findElement(By.id("search_query_top")).sendKeys("dress");
			//driver.findElement(By.name("submit_search")).click();
		}
		
		//INVALID LOGIN
		@Test
		public void invalidLogin() throws InterruptedException {			 
			//Navigating to Registration page
			driver.findElement(By.className("login")).click();		
			//Register Formalities
			driver.findElement(By.id("email")).sendKeys("deekshashetty1098@gmail.com");
			//INCORRECT PASSWORD
			driver.findElement(By.id("passwd")).sendKeys("abc12903");	
			driver.findElement(By.id("SubmitLogin")).click();
			System.out.println("Incorrect Password");
			//Navigating to Registration page
			driver.findElement(By.className("login")).click();		
			//Register Formalities
			//INCORRECT EMAIL ID
			driver.findElement(By.id("email")).sendKeys("deekshashetty111098@gmail.com");
			//INCORRECT PASSWORD
			driver.findElement(By.id("passwd")).sendKeys("abc123");	
			driver.findElement(By.id("SubmitLogin")).click();
			System.out.println("Incorrect Email ID");		
		}
		
		@Test
		public void AddToCart() throws InterruptedException {
			driver.get("http://automationpractice.com/index.php?id_product=5&controller=product&search_query=dress&results=7");
			driver.findElement(By.id("add_to_cart")).click();			
		}
		

		@BeforeClass
		public void startFireFox() {
			System.setProperty("webdriver.gecko.driver", "D:\\firefoxDriver\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);			
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
		}

		@AfterClass
		public void cleaupProc() {				
			System.out.print("\nBrowser close");
			//driver.quit();
		}

	
	
}
