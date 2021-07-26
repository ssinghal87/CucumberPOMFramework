Feature: Account Page Feature

Background: 
Given User has already logged in to Application
|Username|Password|
|Sarthak.Singhal8723@gmail.com|Sarthak@87|


Scenario: Account Page title Test
Given User is on the Account Page
Then  User gets the title of the page
Then  Page title should be "My account - My Store"


Scenario: Account section count test
Given User is on the Account Page
Then  User gets the account section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And   Account section count should be 6