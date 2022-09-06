#Feature: Place Validation API Test
#
 #-------POST API Test---------------------
#@APITest @APITestPost @Sanity @FF
#Scenario Outline: Verify that place is added successfully using add place post api 
#Given Add a place payload with "<name>" "<language>" and "<address>" 
#When User calls "AddPlaceAPI" with "POST" http request
#Then API call got success with status code 200
#And "status" in response body is "OK"
#
#Examples:
#
#|name 		| language  | address 					  |
#|India  	|	Hindi 		|	Sector 74 noida			|
#|USA    	|	English		|	state street   			|
#
#
 #-------GET API Test---------------------
#@APITest @APITestGet @Regression
#Scenario Outline: Verify that GET API is successfully getting the places
#Given Add a place payload with "<name>" "<language>" and "<address>" 
#When User calls "AddPlaceAPI" with "POST" http request
#Then API call got success with status code 200
#And "status" in response body is "OK"
#When Verify the "<name>" when user calls the "GetPlaceAPI" 
#
#Examples:
#
#|name 		| language  | address 					  |
#|India  	|	Hindi 		|	Sector 74 noida			|
#
#
 #-------PUT API Test---------------------
#@APITest @APITestPut
#Scenario Outline: Verify that PUT API is successfully updating the places
#Given Add a place payload with "<name>" "<language>" and "<address>" 
#When User calls "AddPlaceAPI" with "POST" http request
#Then API call got success with status code 200
#And "status" in response body is "OK"
#When Update a place payload with "<updatedAddress>"
#And User calls "UpdatePlaceAPI" with "PUT" http request 
#
#Examples:
#
#|name 		| language  | address 					  | updatedAddress      |
#|India  	|	Hindi 		|	Sector 74 noida			|	Sector 84 gurgaon		|
#
#
#
#
