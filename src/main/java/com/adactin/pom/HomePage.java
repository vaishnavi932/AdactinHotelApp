package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{	
	 public  WebDriver driver;
	 public HomePage(WebDriver hdriver) 
	{
		 this.driver=hdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="login")
	private WebElement login;
	@FindBy(xpath="//img[@class=\"logo\"]")
	private WebElement logo;

	
	public WebElement getLogo() {
		return logo;
	}
	public WebElement getUsername() 
	{
		return username;
	}
	public WebElement getPassword() 
	{
		return password;
	}
	public WebElement getLogin() 
	{
		return login;
	}
}
