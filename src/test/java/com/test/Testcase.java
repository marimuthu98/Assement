package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.com.Baseclass;
import base.com.Searchpage;

public class Testcase extends Baseclass {
	Searchpage SEARCH_PAGE;

	
	@BeforeTest
	private void date1(){

		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String time = sdf.format(date);
	    System.out.println("Date: " + date);
	    System.out.println("Current time: " + time);
	}
	

	@BeforeClass
	private void BROWSER_LANUCH() throws InterruptedException {
         browserLanuch();
	}		
	@Test
	public void TC_1() throws InterruptedException {
	
		implicitlyWait(20);
		SEARCH_PAGE = new Searchpage(driver);
		SEARCH_PAGE.search("iphone");
		SEARCH_PAGE.text("iphone 13");
	}
	
//	@AfterClass
//	public void CLOSE_BROWSER() {
//		closeallbrowser();
//	}
//	
//	@AfterTest
//	private void date2(){
//
//		Date date = new Date();
//	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//	    String time = sdf.format(date);
//	    System.out.println("Current time: " + time);
//	}

}
