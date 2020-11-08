Feature: happyfares Website Application Login and logout 

Scenario Outline: Validation of a successful user login and logout scenario 
	Given Navigate to <website> website 
	Given User clicks on Signin button on the landing page 
	Given User clicks on Customer login in the dropdown 
	When User enters mobile number <mobile> 
	And User enters password <password> 
	And User clicks on signin button 
	Then Verify that the user is successfully logged in 
	And User clicks on Logout 
	
	Examples: 
		|website						|	mobile	    | password     	|
		|https://www.happyfares.in/home	|	xxxxxxxxxx	| xxxxxxxxx  	|
		