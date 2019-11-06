package com.cucumber.stepdefinition;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.baseclass.BaseClass;
import com.cucumber.testrunner.TestRunner;
import com.cucumber.utilities.PageObjectManager;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pg = new PageObjectManager(driver);

	@Given("^Launch the hotel reservation application using url$")
	public void launch_the_hotel_reservation_application_using_url() throws Throwable {
		driver.get("https://adactin.com/HotelApp/");
	}

	@Given("^User enter the prakashmano$")
	public void user_enter_the_prakashmano() throws Throwable {
		sendkeys(pg.getLp().getUsername(), "prakashmano");
	}
	@Given("^User enter the (\\d+)$")
	public void user_enter_the(int arg1) throws Throwable {
		sendkeys(pg.getLp().getPassword(), "9841492682");
	}
	@Given("^User click on login$")
	public void user_click_on_login() throws Throwable {
		clickelement(pg.getLp().getLogin());
	}

	@Given("^Launch the hotel reservation application using url one$")
	public void launch_the_hotel_reservation_application_using_url_one() throws Throwable {
		driver.get("https://adactin.com/HotelApp/");

	}

	@Given("^User enter the name one$")
	public void user_enter_the_name_one() throws Throwable {
		sendkeys(pg.getLp().getUsername(), "prakashmano");

	}

	@Given("^User enter the password one$")
	public void user_enter_the_password_one() throws Throwable {
		sendkeys(pg.getLp().getPassword(), "9841492682");

	}

	@Given("^User click on login one$")
	public void user_click_on_login_one() throws Throwable {
		clickelement(pg.getLp().getLogin());

	}

	@Given("^User select the location one$")
	public void user_select_the_location_one() throws Throwable {
		dropdown(pg.getRp().getLocation(), "index", "1");

	}

	@Given("^User select the hotel one$")
	public void user_select_the_hotel_one() throws Throwable {
		dropdown(pg.getRp().getHotels(), "index", "1");

	}

	@Given("^User select the roomtype one$")
	public void user_select_the_roomtype_one() throws Throwable {
		dropdown(pg.getRp().getRoomtype(), "index", "1");

	}

	@Given("^User select the no of rooms one$")
	public void user_select_the_no_of_rooms_one() throws Throwable {
		dropdown(pg.getRp().getNoofrooms(), "index", "1");

	}

	@Given("^User enter the checkin date one$")
	public void user_enter_the_checkin_date_one() throws Throwable {
		sendkeys(pg.getRp().getCheckindate(), "28/11/2019");

	}

	@Given("^User enter the checkout date as date earlier than checkindate one$")
	public void user_enter_the_checkout_date_as_date_earlier_than_checkindate_one() throws Throwable {
		sendkeys(pg.getRp().getCheckoutdate(), "26/11/2019");

	}

	@Given("^User click on search one$")
	public void user_click_on_search_one() throws Throwable {
		clickelement(pg.getRp().getSearch());
	}

	@Then("^verify whether error message is displayed or not one$")
	public void verify_whether_error_message_is_displayed_or_not_one() throws Throwable {
		System.out.println(pg.getRp().getError().getText());
	}

	
}
