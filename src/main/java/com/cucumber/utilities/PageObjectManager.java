package com.cucumber.utilities;

import javax.security.auth.callback.ConfirmationCallback;

import org.openqa.selenium.WebDriver;

import com.cucumber.pom.LoginPage;
import com.cucumber.pom.RoomBookPage;

public class PageObjectManager {
	public static WebDriver driver;
	private LoginPage lp;
	private RoomBookPage rp;
	

	public LoginPage getLp() {
		if (lp == null) {
			lp = new LoginPage(driver);
		}
		return lp;
	}

	public RoomBookPage getRp() {
		if (rp == null) {
			rp = new RoomBookPage(driver);
		}
		return rp;
	}

	

	public PageObjectManager(WebDriver ldriver) {

		this.driver = ldriver;

	}

}
