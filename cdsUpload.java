package cdsUpload;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cdsUpload {
  private WebDriver driver,a;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vipul\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://10.0.20.15:9797/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMCQUpload() throws Exception {
    driver.get(baseUrl + "/Account/Login.aspx?ReturnUrl=%2f");
    driver.findElement(By.id("LoginUser_UserName")).clear();
    driver.findElement(By.id("LoginUser_UserName")).sendKeys("cb_MCQ");
    driver.findElement(By.id("LoginUser_Password")).clear();
    driver.findElement(By.id("LoginUser_Password")).sendKeys("automation");
    driver.findElement(By.id("LoginButton")).click();
    driver.get(baseUrl + "/Lessons/Books/TopicLesson.aspx?chapterId=134453&topicId=247767&Book=102731");
    /*driver.findElement(By.id("MainContent_LoginView1_LB_MyPage_List_dl_Books_BookInfo1_0_imgBook_0")).click();
    driver.findElement(By.xpath("//table[@id='DataList1']/tbody/tr/td/div/h3/a")).click();
    driver.findElement(By.cssSelector("#__sizzle__ > td > #DivTopic")).click();*/
    driver.findElement(By.id("ctl00_MainContent_TopicLesson1_McqGrid_ctl02_ElementInfo1_lnkEdit")).click();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).clear();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).clear();
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("rblMediaType_1")).click();
   // driver.findElement(By.id("rblMediaType_0")).click();
    driver.findElement(By.linkText("Edit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | Win | 30000]]
    
    String winHandleBefore = driver.getWindowHandle();
    for(String winHandle:driver.getWindowHandles())
    {
    	driver.switchTo().window(winHandle);
      
    }
    //driver.close();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_RadioButtonList1_0")).click();
    new Select(driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_ddlBloomLevel"))).selectByVisibleText("1 - Remember");
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_rbComplexity_0")).click();
    //driver.findElement(By.cssSelector("span.RBEasy > label")).click();
    Thread.sleep(2000);
   // driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_FileUpload1")).clear();
    
   // driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_FileUpload1")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
    Thread.sleep(2000);
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_RadioButton1")).click();
//    driver.findElement(By.id("btnSubmit")).click();
    Thread.sleep(2000);
    System.out.println("Question");
    //var elm = element(by.id("myid"));
    //browser.executeScript("arguments[0].click();", elm);
    //WebElement tbq=driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_t_a"));
    //((JavascriptExecutor) driver).executeScript("arguments[0].visible = true", tbq);
    // jse=(JavascriptExecutor)driver;
    //document.get
    //jse.executeScript("document.getElementsByid, arg1)
    //table[@id='MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tb']/tbody/tr/td/table/tbody/tr/td
    //driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tb")).click();
    System.out.println("Question Progress 1");
    //driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tw")).sendKeys("Hello");
    
    //driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_QEditor_WebHtmlEditor1_tb")).click();
    //System.out.println("Question Progress");
    //driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tw")).sendKeys("Question. This is Automation testing recording content");
   // WebDriver driver = new FirefoxDriver();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    System.out.println("Question Progress 2");
    String a="document.getElementsByName('MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tb').setAttribute('value','my value is high');";
    jse.executeScript(a);
    String a1="document.getElementsByName('MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tw').value='type';";
    jse.executeScript(a1);
    String a2="document.getElementsByName('MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_ts').value='type';";
    jse.executeScript(a2);
    String a3="document.getElementsByName('MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1').value='type';";
    jse.executeScript(a3);
    Thread.sleep(5000);
    System.out.println("Question Progress 3");
    //driver.findElement(By.name("")))
    //driver.findElement(By.xpath("//table[@id='MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tb']//input[@type='text']")).clear();
    driver.findElement(By.name("MainContent_AddToQuestionBank1_QuestionEditor1_QEditor_WebHtmlEditor1_tb")).sendKeys("A. This is Automation testing recording content");
    System.out.println("Question Progress 4");
    driver.findElement(By.xpath("//table[@id='MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tb']//input[@type='text']")).sendKeys("Ripon: body text");
    //driver.findElement(By.xpath("//input[@id='MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1_tw']")).sendKeys("Ripon: body text");
    
    driver.findElement(By.xpath("//table[@id='MainContent_AddToQuestionBank1_QuestionEditor1_QEditer_WebHtmlEditor1']//input[@type='hidden']")).sendKeys("Question. This is Automation testing recording content");
    //("MainContent_AddToQuestionBank1_QuestionEditor1_AEditor_WebHtmlEditor1_tb") )).sendKeys();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_AEditor_WebHtmlEditor1_tb")).click();
    driver.switchTo().frame("MainContent_AddToQuestionBank1_QuestionEditor1_AEditor_WebHtmlEditor1_tw");
        
    //JavascriptExecutor jse=(JavascriptExecutor) driver;
    System.out.println("Question Done before VIP 3");
    //String s="document.getElementsById('MainContent_AddToQuestionBank1_QuestionEditor1_QEditor_WebHtmlEditor1_t_a').value='VIP'";
    
    
    jse.executeScript("document.getElementById('MainContent_AddToQuestionBank1_QuestionEditor1_QEditor_WebHtmlEditor1_t_a').setAttribute('value','VIP')");
    System.out.println("Question Done before VIP 3.5");
    
    //jse.executeScript(s);
    Thread.sleep(5000);
    //table[@id='MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tb']/tbody/tr/td/table/tbody/tr/td
    System.out.println("Question Done after VIP4");

    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_AEditor_WebHtmlEditor1_tw")).sendKeys("A. This is Automation testing recording content");
    driver.findElement(By.xpath("//body")).sendKeys("A. This is Automation testing recording content");
    
    Thread.sleep(2000);
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_BEditor_WebHtmlEditor1_tb")).click();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_BEditor_WebHtmlEditor1_tw")).sendKeys("B. This is Automation testing recording content");
    Thread.sleep(2000);
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_CEditor_WebHtmlEditor1_tb")).click();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_CEditor_WebHtmlEditor1_tw")).sendKeys("C. This is Automation testing recording content");
    Thread.sleep(2000);
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tb")).click();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_DEditor_WebHtmlEditor1_tw")).sendKeys("D. This is Automation testing recording content");
    Thread.sleep(2000);
    Thread.sleep(2000);
    driver.switchTo().window(winHandleBefore);
    
    driver.findElement(By.id("btnSave")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
