package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel 
{
	 public  WebDriver driver;
	 public SearchHotel(WebDriver sdriver) 
	{
		 this.driver=sdriver;
		PageFactory.initElements(driver, this);
	}
	 	@FindBy(id="location")
		private WebElement location;
		@FindBy(id="hotels")
		private WebElement hotel;
		@FindBy(id="room_type")
		private WebElement room;
		@FindBy(id="room_nos")
		private WebElement room_no;
		@FindBy(id="datepick_in")
		private WebElement chk_in;
		@FindBy(id="datepick_out")
		private WebElement chk_out;
		@FindBy(id="adult_room")
		private WebElement adult_room;
		@FindBy(id="child_room")
		private WebElement child_room;
		@FindBy(id="Submit")
		private WebElement submit;
		
		public WebElement getLocation() 
		{
			return location;
		}
		public WebElement getHotel() 
		{
			return hotel;
		}
		public WebElement getRoom() 
		{
			return room;
		}
		public WebElement getRoom_no() 
		{
			return room_no;
		}
		public WebElement getChk_in() 
		{
			return chk_in;
		}
		public WebElement getChk_out() 
		{
			return chk_out;
		}
		public WebElement getAdult_room() 
		{
			return adult_room;
		}
		public WebElement getChild_room() 
		{
			return child_room;
		}
		public WebElement getSubmit() 
		{
			return submit;
		}


}
