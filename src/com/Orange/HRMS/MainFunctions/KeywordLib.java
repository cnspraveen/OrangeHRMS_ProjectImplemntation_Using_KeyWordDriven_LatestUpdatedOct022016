package com.Orange.HRMS.MainFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Orange.HRMS.GenericFunctions.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class KeywordLib {

	public static void enter(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   driver.findElement(Locator.getLocator(ElementRepo)).clear();	
		   driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
		   ETest.log(LogStatus.INFO, input + "is Enter in related field ");
	 }
	
	public static void click(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   driver.findElement(Locator.getLocator(ElementRepo)).click();
		   ETest.log(LogStatus.INFO, input + "is click ");
	 }
	
	public static void select(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   WebElement WeblistEle = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(WeblistEle);
		   select.selectByVisibleText(input);
		   System.out.println("Selected value is  : " + input);
		   ETest.log(LogStatus.PASS,  "Selected value is  : " + input);
	}
	
	public static void CalenderCheck(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
		   WebElement weblist = driver.findElement(Locator.getLocator(ElementRepo));
		   Select select = new Select(weblist);
		   String weblistText = select.getFirstSelectedOption().getText();
		   if(weblistText.contains(input))
		   {
			   System.out.println("Current Month is:  " + input);
			   ETest.log(LogStatus.PASS,  "Current Month is:  " + input);
		   }
		   else{
			   System.out.println("Calender doesn't display : " + input + "Month");
			   ETest.log(LogStatus.FAIL,  "Calender doesn't display : " + input + "Month");
			   select.selectByVisibleText(input);
			   System.out.println("Current Month Selected is : " + input);
			   ETest.log(LogStatus.PASS, "Current Month Selected is : " + input);
		       }
	}
	
	/*  Copy of   verifyTextContains()   or  Similar function as verifyTextContains()   Alternate 
	/* public static void VerifyText(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	 
	{
	   String text = driver.findElement(Locator.getLocator(ElementRepo)).getText();
	   System.out.println("Link text value is " + text);
	   ETest.log(LogStatus.INFO, "Link text value is " + text);
	   
	   String ActualResult = driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("class");
	   String ExpectedResult = input;
	   ETest.log(LogStatus.INFO, "Actual Result" + ActualResult);
	   ETest.log(LogStatus.INFO, "Expected Result" + ExpectedResult);
	   Assert.assertEquals(ExpectedResult, ActualResult);
	} */
	
	public static void VerfiyElementPresent(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
 	    /*if(driver.findElements(Locator.getLocator(ElementRepo)).size()==0)
 	      {	  
 	    	System.out.println("Element is not present");   
 	    	ETest.log(LogStatus.FAIL, "Element is not present");
 	    	}
 	   else  
 	   {
 		    if(driver.findElement(Locator.getLocator(ElementRepo)).isDisplayed())
 		   {  	  System.out.println("Element is displayed");   
 		          ETest.log(LogStatus.PASS, "Element is present");}
 		    else
 			{    
 		    	ETest.log(LogStatus.FAIL, "Element is not present or not displayed");
 		    	//System.out.println("Element is not present"); 
 		    	}
 		}
 	   System.out.println("Element is present :::::"  + input); */
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		List<WebElement> elements = driver.findElements(Locator.getLocator(ElementRepo));
		if(elements.size()> 0 && elements.get(0).isDisplayed())
		{
			ETest.log(LogStatus.PASS,"Element is Present and Displayed");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Element is Not Present or Displayed");
		}
      }
 	
	public static void hover(WebDriver driver,String action,String input1,String input2,ExtentTest testReport)
	{
		testReport.log(LogStatus.INFO, "Moving mouse on the element");
		WebElement element = driver.findElement(Locator.getLocator(input1));
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	
	public static void upload(WebDriver driver, String Action, String ElementRepo, String input, ExtentTest ETest)
	{
    	//driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
    	//System.out.println("Photo has been Uploaded");
    	//ETest.log(LogStatus.PASS, "Photo has been Uploaded");

    	//System.out.println(driver.getTitle());
    	String ActualResult_absoluteFilePath=new File(input).getAbsolutePath();
    	ETest.log(LogStatus.INFO,"absoluteFilePath:"+ActualResult_absoluteFilePath);
		driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(ActualResult_absoluteFilePath);
		ETest.log(LogStatus.PASS, "Photo has been Uploaded");
	}
	
	
	
	public static void verifyTextContains(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		String text_getText=driver.findElement(Locator.getLocator(ElementRepo)).getText();
		String text_innerHTML=driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("innerHTML");
		//String text_textContent=driver.findElement(Locator.getLocator(ElementRepo)).getAttribute("textContent");
		ETest.log(LogStatus.INFO, "Expected text is:"+input);
		ETest.log(LogStatus.INFO, "getText:"+text_getText);
		ETest.log(LogStatus.INFO, "innerHTML:"+text_innerHTML);
		//ETest.log(LogStatus.INFO, "textContent:"+text_textContent);
		if(text_getText.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using getText; Actual text contains Expected text");
		}
		else if(text_innerHTML.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using innerHTML; Actual text contains Expected text");
		}
		/*else if(text_textContent.contains(input))
		{	
			ETest.log(LogStatus.PASS,"Verified using textContent; Actual text contains Expected text");
		}*/
		else
		{
			ETest.log(LogStatus.FAIL,"Actual text DO NOT contains Expected text");
		}
 }
	
	public static void verifyImage(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest) //throws InterruptedException
	{
		//Thread.sleep(3000);
		String actualImageComplete=Utility.GetPageScreenShot(driver, Delta.ActualImageFolder);   
				//Utility.getPageScreenShot(driver, AutomationConstants.ActualImageFolder);
		String expectedImage=Delta.ExpectedImageFolder+"/"+input;
		int x=driver.findElement(Locator.getLocator(ElementRepo)).getLocation().getX();
		int y=driver.findElement(Locator.getLocator(ElementRepo)).getLocation().getY();
		int width=driver.findElement(Locator.getLocator(ElementRepo)).getSize().getWidth();
		int height=driver.findElement(Locator.getLocator(ElementRepo)).getSize().getHeight();
		String actualImage=Utility.cropImage(actualImageComplete,x,y,width, height, Delta.ActualImageFolder);
		
		if(Utility.compareImage(actualImage,expectedImage))
		{
			String p = ETest.addScreenCapture("."+actualImage);
			ETest.log(LogStatus.PASS,"Image verified is:"+p);
		}
		else
		{
			String e=ETest.addScreenCapture("."+expectedImage);
			ETest.log(LogStatus.FAIL,"Expected image is:"+e);
			String a=ETest.addScreenCapture("."+actualImage);
			ETest.log(LogStatus.FAIL,"Actual image is:"+a);
			
		}
	}
	
	public static void verifyElementColor(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		
		String strRGB=driver.findElement(Locator.getLocator(ElementRepo)).getCssValue("color");
		ETest.log(LogStatus.INFO,"RGB is:"+strRGB);
		String hex=Utility.convertRGBtoHex(strRGB);
		
		String msg1="<span style='color:"+input+";'>Expected color</span>";
		ETest.log(LogStatus.INFO,"HTML",msg1);
		
		String msg2="<span style='color:"+hex+";'>Actual color</span>";
		ETest.log(LogStatus.INFO,"HTML",msg2);
		
		
		if(hex.equals(input))
		{
			ETest.log(LogStatus.PASS,"Element color is matching");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Element color is not matching");
		}
	}
	
	public static void deSelectAllCheckBoxes(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		 List<WebElement> allCheckBox = driver.findElements(Locator.getLocator(ElementRepo));
		for(WebElement chkBox:allCheckBox)
		{
			if(chkBox.isSelected())
			{
				chkBox.click();
			}
			else
			{
				ETest.log(LogStatus.INFO,"CheckBox is Already DeSelected");
			}
		}
	}
	public static void selectAllCheckBoxes(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		 List<WebElement> allCheckBox = driver.findElements(Locator.getLocator(ElementRepo));
		for(WebElement chkBox:allCheckBox)
		{
			if(chkBox.isSelected())
			{
				ETest.log(LogStatus.INFO,"CheckBox is Already Selected");
			}
			else
			{
				chkBox.click();
				
			}
		}
	}
	public static void verifyElementDisabled(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		WebElement element = driver.findElement(Locator.getLocator(ElementRepo));
		if(element.isEnabled())
		{
			ETest.log(LogStatus.FAIL,"Specified Element is Not Disabled");
		}
		else
		{
			ETest.log(LogStatus.PASS,"Specified Element is Disabled");
		}
	}
	public static void verifyElementEnabled(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		WebElement element = driver.findElement(Locator.getLocator(ElementRepo));
		if(element.isEnabled())
		{
			ETest.log(LogStatus.PASS,"Specified Element is Enabled");
			
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Specified Element is Not Enabled");
		}
	}
	public static void VerifyListBoxContent(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		WebElement listBox = driver.findElement(Locator.getLocator(ElementRepo));
		String[] allOptions = input.split(",");
		for(String option:allOptions)
		{	
			boolean present = Utility.isOptionPresentinListBox(listBox,option);
			if(present)
			{
				ETest.log(LogStatus.PASS,"Specified Option is Present:"+option);
			}
			else
			{
				ETest.log(LogStatus.FAIL,"Specified Option is Not Present:"+option);
			}
		}
	}
	public static void verifySelectedOption(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest) // Done
	{
		WebElement listBox = driver.findElement(Locator.getLocator(ElementRepo));
		String actualSelected=new Select(listBox).getFirstSelectedOption().getText();
		ETest.log(LogStatus.INFO,"Selected option is:"+actualSelected);
		ETest.log(LogStatus.INFO,"Expected option to be Selected is:"+input);
		if(actualSelected.equals(input))
		{
			ETest.log(LogStatus.PASS,"Specified Option is Selected");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"Specified Option is Not Selected");
		}
	}
	public static void verifyListBoxIsSorted(WebDriver driver,String action,String ElementRepo,String input,ExtentTest ETest) // Done
	{
		WebElement listBox = driver.findElement(Locator.getLocator(ElementRepo));
		
		if(Utility.isListBoxSorted(listBox))
		{
			ETest.log(LogStatus.PASS,"ListBox is Sorted");
		}
		else
		{
			ETest.log(LogStatus.FAIL,"ListBox is Not Sorted");
		}
	}
	public static void moveFileToFrameWork(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		String home = System.getProperty("user.home");//home directory of user.
		String completeSrcFilePath=home+"/"+ElementRepo;
		String completeDstFilePath="./"+input+"/";
		try {
			FileUtils.moveFileToDirectory(new File(completeSrcFilePath), new File(completeDstFilePath),true);
		} //cut and paste the file.
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeDataToCsv(WebDriver driver,String Action,String ElementRepo,String input,ExtentTest ETest)
	{
		System.out.println("Write dato to csv start ");
		
		String completeFilePath=Delta.CsvFolderPath+"/"+ElementRepo;
		completeFilePath=new File(completeFilePath).getAbsolutePath();
		System.out.println(completeFilePath);
		ETest.log(LogStatus.INFO,"CSV file path:"+completeFilePath);
		String column=input.split("=")[0];
		ETest.log(LogStatus.INFO,"CSV Column:"+column);
		String value=input.split("=")[1];
		ETest.log(LogStatus.INFO,"CSV Value:"+value);
		
		try{
	//reading the header of csv
	FileReader fr=new FileReader(new File(completeFilePath));
	BufferedReader br=new BufferedReader(fr);
	String[] allHeader = br.readLine().split(",");
	String[] allValues=null;
	try{
		allValues = br.readLine().split(",");
	}catch(Exception e)
	{
		
	}
	Map<String,String> mp=new LinkedHashMap<String,String>();
	int i=0;
	for(String key:allHeader)
	{
		String v="";
		try{
			v=allValues[i++];
		}catch(Exception e){}
		mp.put(key,v);
	}
	fr.close(); 
	mp.put(column,value);
	 
	//writing the data on particular header column
	FileWriter fw=new FileWriter(new File(completeFilePath));
	BufferedWriter bw=new BufferedWriter(fw);
	String allKey="";
	String allValue="";
	for(Map.Entry m:mp.entrySet())
	{
		allKey=allKey+m.getKey()+",";
		allValue=allValue+m.getValue()+",";
	}
	System.out.println(allValue);
	bw.write(allKey);
	bw.newLine();
	bw.write(allValue);
	bw.close();
	fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Write dato to csv end ");
	}
	
	
	
	
}

