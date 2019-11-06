Feature: Adactin hotel page automation scripts


@TC-101
Scenario Outline: To verify the login details
Given Launch the hotel reservation application using url
And User enter the <name>
And User enter the <password>
And User click on login

Examples:
|name|password|
|prakashmano|9841492682|


@TC-102
Scenario: To check whether checkout datefield accepts date earlier than checkin date
Given Launch the hotel reservation application using url one
And User enter the name one
And User enter the password one
And User click on login one 
And User select the location one
And User select the hotel one
And User select the roomtype one
And User select the no of rooms one
And User enter the checkin date one
And User enter the checkout date as date earlier than checkindate one
And User click on search one
Then verify whether error message is displayed or not one

