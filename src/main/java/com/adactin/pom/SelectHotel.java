package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel
{
public WebDriver driver;
	
	public SelectHotel(WebDriver sedriver)
	{
		this.driver=sedriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement radio_btton;
	@FindBy(id="continue")
	private WebElement clk_continue;
	
	public WebElement getRadio_btton() 
	{
		return radio_btton;
	}
	public WebElement getClk_continue() 
	{
		return clk_continue;
	}

}
