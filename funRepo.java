package cdsUpload;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class funRepo {
	
	private static Logger Log = Logger.getLogger(CreateSQA.class.getName());
	public  void loGin(Properties P, WebDriver driver) throws Exception  {
		
		DOMConfigurator.configure("log4j.xml");
		Log.info("Initiate the Browser");
		driver.get(P.getProperty("url")+"/Account/Login.aspx");
		Log.info("Navigate to CDS Login page");
	    Thread.sleep(1000);
		Thread.sleep(1000);
	
		enterText(driver,P.getProperty("txtUserName"), "UserName");
		enterText(driver,P.getProperty("txtPassword"), "Password");
		clickBtn(driver, P.getProperty("btnLogin"));
		  }


	public  void editSQA(Properties P, WebDriver driver,String BookId, String Chapter) throws Exception {
		driver.get(P.getProperty("url")+"/Lessons/Books/ChapterList.aspx?id="+BookId+"");
		//System.out.println(baseUrl+" "+BookId+" "+Chapter);
		Thread.sleep(5000);
		
	    driver.findElement(By.partialLinkText(Chapter)).click();
	    Thread.sleep(5000);
	    //clickBtn(driver, P.getProperty("EditLinkSQA"))
	    driver.findElement(By.xpath(P.getProperty("EditLinkSQA"))).click();
	    Thread.sleep(5000);
        Log.info("Creating Questions for the Chapter : "+Chapter);
	}
	
	
	public void SaveSQA(Properties P, WebDriver driver, String DisplayName, String Keyword)
	{ 
      	
		enterText(driver,P.getProperty("txtDisplayName"), DisplayName);
		enterText(driver,P.getProperty("txtKeyword"), Keyword);
		clickBtn(driver, P.getProperty("btnSave"));
		Log.info("Question Set is created..... ");
	} 

	
	public void enterText(WebDriver driver, String Element, String Input)
	{
		driver.findElement(By.id(Element)).clear();
	    driver.findElement(By.id(Element)).sendKeys(Input);
	    
	}
	
	public void clickBtn(WebDriver driver, String Btn)
	{
	    driver.findElement(By.id(Btn)).click();
	}
	

	public void addQuestion(Properties P, WebDriver driver, String Question, int i, String QuestionImage, String Answer, String BloomLevel, String Complexity) throws Exception{
	String parentHandle = driver.getWindowHandle();
    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])["+i+"]")).click();
    Thread.sleep(2000);
    for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle);
    }
    
    driver.switchTo().frame(0);
    WebElement q1  =  driver.switchTo().activeElement();
    new Actions(driver).moveToElement(q1).perform();
    driver.findElement(By.xpath("/html/body")).clear();
    driver.findElement(By.xpath("/html/body")).sendKeys(Question);

     
     
     // driver.findElement(By.xpath(".//*[@id='MainContent_SQAEditor_QHTML_WebHtmlEditor1_tb_ctl04_image']")).click();
      
      
      for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
     } 
      
      //Check for Question image is available or not
      if(QuestionImage.length()> 0) 
      {
    	  
    	  UploadImage(P,driver,QuestionImage,i);  
    	  
      }
      
     
      
      driver.switchTo().frame(1);
      WebElement Ans1  =  driver.switchTo().activeElement();
      new Actions(driver).moveToElement(Ans1).perform();
      driver.findElement(By.xpath("/html/body")).clear();
      driver.findElement(By.xpath("/html/body")).sendKeys(Answer); 
      
      for (String winHandle : driver.getWindowHandles()) {
          driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
     } 
      
      Select oSelect = new Select(driver.findElement(By.id("MainContent_SQAEditor_ddlBloomLevel")));
      switch(BloomLevel) {
      case "Remember" :
      oSelect.selectByVisibleText("1 - Remember");
      break;
      case "Understand" :
          oSelect.selectByVisibleText("2 - Understand");
          break;
      case "Apply" :
          oSelect.selectByVisibleText("3 - Apply");
          break;
      case "Analyse" :
          oSelect.selectByVisibleText("4 - Analyze");
          break;
      case "Evaluate" :
          oSelect.selectByVisibleText("5 - Evaluate");
          break;
      case "Create" :
    	  oSelect.selectByVisibleText("6 - Create");
          break;
       default :
         System.out.println("Bloom Level is not defined ");
          break;
      
      }
      
      switch(Complexity){
      case "Easy" :
      	driver.findElement(By.id("rbComplexity_0")).click();
      	break;
      case "Medium" :
      	driver.findElement(By.id("rbComplexity_1")).click();
      	break;
      case "Difficult" :
        	driver.findElement(By.id("rbComplexity_2")).click();
        	break;
      	default :
      		System.out.println("Complexity is not defined ");
      	
      }
      Thread.sleep(5000);
      driver.findElement(By.id("MainContent_SQAEditor_btnSave")).click();
      Thread.sleep(5000);
      Log.info("Question No. "+i+" has been created......");
      driver.switchTo().window(parentHandle);
      
}
	
	public void UploadImage(Properties P,WebDriver driver,String QuestionImage,int i) throws InterruptedException
	{
		Thread.sleep(5000);
	  	   driver.findElement(By.id(P.getProperty("QImageBtn"))).click();
	  	   Thread.sleep(2000);
	    
	  	  for (String winHandles : driver.getWindowHandles()) {
	  		  driver.switchTo().window(winHandles); }
	    
	  	  driver.findElement(By.name(P.getProperty("ImgBrowseBtn"))).sendKeys(QuestionImage);
	  	  Thread.sleep(2000);
	  	  driver.findElement(By.name(P.getProperty("ImgUploadBtn"))).click();
	  	  Thread.sleep(2000);
	  	  
	  	  driver.switchTo().alert().accept(); 

	  	  Log.info("Question Image is for Question No. "+i+" has been successfully uploaded......");
	  	  Thread.sleep(2000);
	  	  driver.findElement(By.xpath(P.getProperty("ImgSelectBtn"))).click();
	  	  Thread.sleep(2000);
	  	  
	  	  for (String winHandles : driver.getWindowHandles()) {
		          driver.switchTo().window(winHandles); }
	  	  
	  
	  	  driver.findElement(By.id("MainContent_SQAEditor_QHTML_WebHtmlEditor1_ts_h")).click();
	  	  Thread.sleep(5000);
	  	  driver.switchTo().frame(0);
		  WebElement h1  =  driver.switchTo().activeElement();
		  new Actions(driver).moveToElement(h1).perform();
		  String text= driver.findElement(By.xpath("/html/body")).getText();
		
		      
		  System.out.println("Question Text is =====>"+text);
		
		  String  QuestionText = text.split("<img src")[0];
		

		  String ImagePath="<img src"+text.split("<img src")[1];
	
		      
		  String FinalQuestion=QuestionText.replace("&lt;IMG&gt;",ImagePath);
		
		      
		  driver.findElement(By.xpath("/html/body")).clear();
		  driver.findElement(By.xpath("/html/body")).sendKeys(FinalQuestion);
		      
		  for (String winHandle : driver.getWindowHandles()) {
		          driver.switchTo().window(winHandle); }
	}

}
