package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomBookPage {
	WebDriver driver;
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomtype;
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement noofrooms;
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkindate;
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement checkoutdate;
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement search;
	@FindBy(xpath="//span[@id='checkout_span']")
	private WebElement error;
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getError() {
		return error;
	}
	public WebElement getRoomtype() {
		return roomtype;
	}
	public WebElement getNoofrooms() {
		return noofrooms;
	}
	public WebElement getCheckindate() {
		return checkindate;
	}
	public WebElement getCheckoutdate() {
		return checkoutdate;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getLogout() {
		return logout;
	}
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;

	public RoomBookPage(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
}
