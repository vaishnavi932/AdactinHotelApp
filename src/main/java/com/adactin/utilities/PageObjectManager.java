package com.adactin.utilities;

import org.openqa.selenium.WebDriver;

import com.adactin.pom.HomePage;
import com.adactin.pom.SearchHotel;
import com.adactin.pom.SelectHotel;

public class PageObjectManager
{
	
	private HomePage hp;
	private SearchHotel sh;
	private SelectHotel se;
	public WebDriver driver;

	public HomePage getHp() 
	{
		if(hp==null)
		{
			hp=new HomePage(driver);
		}
		return hp;
	}
	public SearchHotel getSh() 
	{
		if(sh==null)
		{
			sh=new SearchHotel(driver);
		}
		return sh;
	}
	public SelectHotel getSe() 
	{
		if(se==null)
		{
			se=new SelectHotel(driver);
		}
		return se;
	}
	
	public PageObjectManager(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	

}
