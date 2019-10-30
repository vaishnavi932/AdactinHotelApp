package com.adactin.stepdefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.adactin.baseclass.BaseClass;
import com.adactin.runner.TestRunnerAdac;
import com.adactin.utilities.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AdacStepDefinition extends BaseClass
{
	public static WebDriver driver=TestRunnerAdac.driver;
	PageObjectManager pg=new PageObjectManager(driver);
	
	@Given("^Launch the adactin hotel web application$")
	public void launch_the_adactin_hotel_web_application() throws Throwable 
	{
		getUrl("https://adactin.com/HotelApp/");
	}

//	@Then("^verify the logo of the page is displayed$")
//	public void verify_the_logo_of_the_page_is_displayed() throws Throwable 
//	{
//		HomePage hp=new HomePage(driver);
//		elementisDisplayed(hp.getLogo());
//	}

	@When("^User should enter the Email Id$")
	public void user_should_enter_the_Email_Id() throws Throwable 
	{	
		//HomePage hp=new HomePage(driver);
		setkey(pg.getHp().getUsername(), "vaishnavid03");

	}

	@When("^User should enter the password$")
	public void user_should_enter_the_password() throws Throwable 
	{
		//HomePage hp=new HomePage(driver);
		setkey(pg.getHp().getPassword(), "68JA1T");

	 }

	@When("^User should click on the login button$")
	public void user_should_click_on_the_login_button() throws Throwable 
	{			
		//HomePage hp=new HomePage(driver);
		click(pg.getHp().getLogin());
	}
	
	@When("^Login to the application using username and password$")
	public void login_to_the_application_using_username_and_password() throws Throwable 
	{
		//HomePage hp=new HomePage(driver);
		setkey(pg.getHp().getUsername(), "vaishnavid03");
		setkey(pg.getHp().getPassword(), "68JA1T");
		click(pg.getHp().getLogin());
	}

	@When("^Select location as in test data$")
	public void select_location_as_in_test_data() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		dropdown(pg.getSh().getLocation(), "index", "2");
	}

	@When("^Select hotel as in test data$")
	public void select_hotel_as_in_test_data() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh =new com.adactin.pom.SearchHotel(driver);
		dropdown(pg.getSh().getHotel(), "value", "Hotel Sunshine");
	}

	@When("^Select room type as in test data$")
	public void select_room_type_as_in_test_data() throws Throwable 
	{
		com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		dropdown(pg.getSh().getRoom(), "index", "1");

	}

	
	@When("^Select no-of-rooms as in test data$")
	public void select_no_of_rooms_as_in_test_data() throws Throwable
	{
		com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		dropdown(pg.getSh().getRoom_no(), "index", "1");

	}

	@When("^Enter check-in-date later than the checkout-date field as in test data$")
	public void enter_check_in_date_later_than_the_checkout_date_field_as_in_test_data() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		setkey(pg.getSh().getChk_in(), "23/09/2019");
		setkey(pg.getSh().getChk_out(), "24/09/2019");
	}

	@Then("^Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’$")
	public void verify_that_system_gives_an_error_saying_check_in_date_should_not_be_later_than_check_out_date() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);

		if (driver.getTitle().equals("AdactIn.com - Search Hotel")) 
		{
			SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
			Date d1 = sd.parse(pg.getSh().getChk_in().getAttribute("value"));
			Date d2 = sd.parse(pg.getSh().getChk_out().getAttribute("value"));
			if (d1.compareTo(d2) == 1) 
			{
				System.out.println("pass");
			}
			else
				System.out.println("fail");
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].setAttribute('style','border:2px solid
				// red;')",sh.getCheckInSpanField());
				//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",sh.get);
		}
	
	}
	
	@When("^Select number of children in test data$")
	public void select_number_of_children_in_test_data() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		dropdown(pg.getSh().getChild_room(), "index", "1");

	}
	@When("^Click on Search button$")
	public void Click_on_Search_button() throws Throwable 
	{
		//com.adactin.pom.SearchHotel sh=new com.adactin.pom.SearchHotel(driver);
		click(pg.getSh().getSubmit());
	}
	@When("^Select the hotel and click on continue button$")
	public void Select_the_hotel_and_click_on_continue_button() throws Throwable 
	{
		//SelectHotel se=new SelectHotel(driver);
		click(pg.getSe().getRadio_btton());
		click(pg.getSe().getClk_continue());
	}

	@Then("^Verify that total-price is being calculated as \\(price-pernight\\*no-ofrooms\\*no-of-days\\)$")
	public void verify_that_total_price_is_being_calculated_as_price_pernight_no_ofrooms_no_of_days() throws Throwable 
	{
		WebElement price = driver.findElement(By.id("price_night_dis"));
		WebElement rooms = driver.findElement(By.id("room_num_dis"));
		WebElement days = driver.findElement(By.id("total_days_dis"));
		Thread.sleep(2000);

		String price_per_ngt =price.getAttribute("value");
		String no_of_rooms = rooms.getAttribute("value");
		String no_of_days = days.getAttribute("value");
		
		String ppn=price_per_ngt.substring(6);
		String nor=no_of_rooms.substring(0, 1);
		String nod=no_of_days.substring(0, 1);


		int p=Integer.parseInt(ppn);		
		int r=Integer.parseInt(nor);
		int d=Integer.parseInt(nod);
		System.out.println(+p);
		
		int est_total=p*r*d;
		System.out.println("estimated bill amount "+est_total);
		
		WebElement total_price  = driver.findElement(By.id("total_price_dis"));
		String tot = total_price.getAttribute("value");
		String tp=tot.substring(6);
		int bill_total= Integer.parseInt(tp);
		System.out.println("genetared bill amount " +bill_total);
		
		if(est_total==bill_total) 
		{
			System.out.println("bill amount correct");
		}
		else
			System.out.println("bill amount incorrect");
		
	    
	}

}