Feature: Login Page Feature


Scenario: Login Page Title Test 
Given User is on the Login Page
When  User gets the title of the page 
Then  Page title should be "Login - My Store"

Scenario: Forgot Password Link Check
Given User is on the Login Page
When  Forgot Password link should be displayed

Scenario: Login with Correct Credentials
Given User is on the Login Page
When  User enters the username "Sarthak.Singhal8723@gmail.com"
And   User enters the password "Sarthak@87"
And   User clicks on the Login button
Then  User gets the title of the page
And   Page title should be "My account - My Store"