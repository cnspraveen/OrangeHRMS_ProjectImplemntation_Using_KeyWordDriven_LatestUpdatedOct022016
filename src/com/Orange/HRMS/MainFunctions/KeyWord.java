package com.Orange.HRMS.MainFunctions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interActions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class KeyWord
{
   public static void ExecuteKeyWord(WebDriver driver,String Action, String ElementRepo, String input, ExtentTest ETest ) throws InterruptedException
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   KeywordLib.enter(driver, Action, ElementRepo, input, ETest);
		   
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   KeywordLib.click(driver, Action, ElementRepo, input, ETest);
	   }
	   else if(Action.equalsIgnoreCase("Select"))
	   {
		   KeywordLib.select(driver, Action, ElementRepo, input, ETest);   
	   }
	   else if(Action.equalsIgnoreCase("Calender Check"))
	   {
		   KeywordLib.CalenderCheck(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("Verify Text"))
	   {
		   KeywordLib.verifyTextContains(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   
	   else if(Action.equalsIgnoreCase("VerfiyElementPresent"))
	   {
		   KeywordLib.VerfiyElementPresent(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("upload"))
	   {
		   KeywordLib.upload(driver, Action, ElementRepo, input, ETest);
	   }
	   
	   else if(Action.equalsIgnoreCase("verifyImage"))
		{
			KeywordLib.verifyImage(driver, Action, ElementRepo, input, ETest);
		}
	   else if(Action.equalsIgnoreCase("verifyElementColor"))
		{
			KeywordLib.verifyElementColor(driver, Action, ElementRepo, input, ETest);
		}
	   
	   
	   //========================================================
	   
		else if(Action.equalsIgnoreCase("verifyElementNotPresent"))
		{
			//KeywordLib.verifyElementNotPresent(driver, Action, ElementRepo, input,ETest);
		}
		else if(Action.equalsIgnoreCase("verifyImage"))
		{
			KeywordLib.verifyImage(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("SelectFileToUpload"))
		{
			KeywordLib.upload(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("verifyElementColor"))
		{
			KeywordLib.verifyElementColor(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("VerifyTextContains"))
		{
			KeywordLib.verifyTextContains(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("hover"))
		{
			KeywordLib.hover(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("wait"))
		{
			//KeywordLib.wait(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("selectSaveOnPopUp"))
		{
			//KeywordLib.selectSaveOnPopUp(driver, Action, ElementRepo, input, ETest);
		}
		
		else if(Action.equalsIgnoreCase("pressEnter"))
		{
			//KeywordLib.pressEnter(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("writeDataToCsv"))
		{
			//KeywordLib.writeDataToCsv(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("moveFileToFrameWork"))
		{
			KeywordLib.moveFileToFrameWork(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("VerifyListBoxIsSorted"))
		{
			KeywordLib.verifyListBoxIsSorted(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("VerifySelectedOption"))
		{
			KeywordLib.verifySelectedOption(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("VerifyListBoxContent"))
		{
			KeywordLib.VerifyListBoxContent(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("verifyElementDisabled"))
		{
			KeywordLib.verifyElementDisabled(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("verifyElementEnabled"))
		{
			KeywordLib.verifyElementEnabled(driver, Action, ElementRepo, input, ETest);
		}
		
		else if(Action.equalsIgnoreCase("selectAllCheckBoxes"))
		{
			KeywordLib.selectAllCheckBoxes(driver, Action, ElementRepo, input, ETest);
		}
		else if(Action.equalsIgnoreCase("deSelectAllCheckBoxes"))
		{
			KeywordLib.deSelectAllCheckBoxes(driver, Action, ElementRepo, input, ETest);
		}
		
	   else
	   {  System.out.println("invalid Action"+Action);  
	   ETest.log(LogStatus.ERROR, "invalid Action :  "+  Action);}
   } 
}
