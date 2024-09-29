Feature: Actitime Login validation

Scenario: Validate Actitime Login with valid user
Given User is on actitime login page
When User enters username as "admin01"
And User enters password as "admin01"
And User clicks on login button
Then User should navigate to Actitime Home page with title "actiTIME - Enter Time-Track"
And User close the browser

Scenario: Validate Actitime Login with invalid user
Given User is on actitime login page
When User enters username as "admin"
And User enters password as "admin01"
And User clicks on login button
Then User should navigate to Actitime Home page with title "actiTIME - Login"
And User close the browser