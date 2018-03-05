package cdsUpload;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class getMetaData {
	  private static final String NULL = null;
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  String Metadata="";
	  int rowindex=1;
	static String xlpath="D:\\Automation\\AutoitScripts\\workspace\\cdsUpload\\src\\cdsUpload\\SampleMetadata.xlsx";
	 

 @BeforeTest(alwaysRun = true)
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\browser_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://textalyser.net";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		 }
	
	@DataProvider(name = "Input_DATA")
	public static Object[][] readExcel() throws Exception {
		readExcel re = new readExcel();
		return re.readXLSX(xlpath, "Sheet1");
	}

	
	@Test(priority = 1, dataProvider = "Input_DATA")
	public void enterTxt(@Optional String Sno, @Optional String CMSID, @Optional String DisplayName, @Optional String DBKeywords,  String Frame, @Optional String Result) throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/textarea")).clear();
		driver.findElement(By.xpath("/html/body/form/textarea")).sendKeys(Frame);
		driver.findElement(By.xpath("/html/body/form/input")).click();
		 //Get number of rows In table.
		 int Row_count = driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]")).size();
		 List<WebElement> metadata=driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]"));
		 for (WebElement webElement : metadata) {
	            
	            Metadata=Metadata+webElement.getText()+", ";
	        }
		writeExcel write= new writeExcel();
		write.writeXLSX(xlpath, "Sheet1", Metadata, rowindex, 5);
		rowindex=rowindex+1;

	    Metadata="";
	}
	
	 @AfterTest
	 public void tearDown() throws Exception { 

	   driver.quit();
	     } 
}
