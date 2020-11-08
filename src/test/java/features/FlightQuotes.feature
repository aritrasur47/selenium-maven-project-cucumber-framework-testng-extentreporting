Feature: Happyfares flight_quotes_page display for one-way trip 

Scenario Outline: Happyfares Flight quotes page is displayed successfully 
	Given Navigate to website <website> 
	When User selects origin city <origin> 
	And User selects destination city <destination> 
	And User selects departure date 
	And User enters passenger details 
	And User clicks on Search button 
	Then Quotes page is displayed 
	
	Examples: 
		| website 							| origin 	  | destination  |
		| https://www.happyfares.in/home	| DELHI       | MUMBAI		 | 