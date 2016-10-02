package com.Orange.HRMS.GenericFunctions;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility 
{
	
  public  static String getFormatCurrentDate()
  {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			  String date = sdf.format(new Date());
			  System.out.println( "date is:  " + date);
			  return date;
  }
  
  public static String GetPageScreenShot(WebDriver  driver , String ImageFolderPath)
  {
	  String imagePath = ImageFolderPath + "/" + getFormatCurrentDate() + ".png";
	  EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	  try{
		  FileUtils.copyFile(edriver.getScreenshotAs(org.openqa.selenium.OutputType.FILE), new File(imagePath));}
	  catch(Exception e){System.out.println("Exception caught in GetPageScreenShot()");}
	  return imagePath;
  }
  
  
  
  public static String cropImage(String imagePath,int x,int y,int width,int height,String OutputImgFolder)
	{
		String newImagePath=OutputImgFolder+"/"+getFormatCurrentDate()+".png";
		try{
			BufferedImage originalImage = ImageIO.read(new File(imagePath));
	        BufferedImage subImage = originalImage.getSubimage(x,y,width,height);
	        ImageIO.write(subImage,"png", new File(newImagePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return newImagePath;
		
		
	}

public static boolean compareImage( String actualImage,String expectedImage) {        
		boolean flg=true;
		try {
		        
				DataBuffer eImg = ImageIO.read(new File(expectedImage)).getData().getDataBuffer();
		        int sizeA = eImg.getSize();         
		        DataBuffer aImg = ImageIO.read(new File(actualImage)).getData().getDataBuffer();
		        int sizeB = aImg.getSize();
		        if(sizeA != sizeB)
		        	{
		        	System.out.println("Size is not equal...");
		        	return false;		        	
		        	}
		        
		            for(int i=0; i<sizeA; i++) {
		                if(eImg.getElem(i) != aImg.getElem(i))
		                {
		                	System.out.println("Expected Image != Actual Image");
		                	flg=false;
		                	return false;
		                }
		            }
		            } catch (Exception e){return  false;}
		    	if(flg)
		    	{
		    		System.out.println("Image Comparsion is successful");
		    	}
		    return true;
		}
  
	public static String convertRGBtoHex(String strRGB)
	{
		String hex="";
		List<Integer> rgb=new ArrayList<Integer>();
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(strRGB);
		 while(m.find())
		 {
			 int v=Integer.parseInt(m.group());
			 rgb.add(v);
		 }
		 System.out.println(rgb.size());
		
		 int red=rgb.get(0);
		 int green=rgb.get(1);
		 int blue=rgb.get(2);
		 hex = String.format("#%02x%02x%02x",red, green,blue);
		 return hex; 
	}
	
	public static void highlightElement(WebDriver driver,WebElement element)
	{
		String presentColor=element.getCssValue("backgroundColor");
		String newCoclor="rgb(255,255,0)";
		
		for(int i=1;i<=3;i++)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='"+newCoclor+"'",element);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='"+presentColor+"'",element);
			
		}
	}
	
	public static boolean isOptionPresentinListBox(WebElement listBox,String option)
	{
		List<WebElement> optionElement = listBox.findElements(By.xpath("./option[text()='"+option+"']"));
		if(optionElement.size()==0){
			return false;}
		else{
			return true;
		}
	}
	
	public static boolean isListBoxSorted(WebElement listBox)
	{
		List<WebElement> allOptions = new Select(listBox).getOptions();
		ArrayList<String> allText=new ArrayList<String>();
		for(WebElement option:allOptions)
		{
			allText.add(option.getText());
		}
		ArrayList<String> allTextSorted=new ArrayList<String>(allText);
		Collections.sort(allTextSorted);
		System.out.println("BEFORE SORT<-->AFTER SORT\n--------------------------");
		for(int i=0;i<allText.size();i++)
		{
			if(allText.get(i).equals(allTextSorted.get(i))){
			System.out.println(allText.get(i)+"<-->"+allTextSorted.get(i));
			}
			else
			{
				System.err.println(allText.get(i)+"<-->"+allTextSorted.get(i));
			}
		}
		System.out.println("--------------------------");
		return allText.equals(allTextSorted);
	}
		

}
