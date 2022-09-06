#Feature: Place Validation API Test
#
# -------POST API Test---------------------
#@APITest @APITestPost
#Scenario: Verify that place is added successfully using add place api 
#Given Add a place payload
#When user calls AddPlaceAPI with post http request
#Then API call got success with status code 200
#And Status in response body is OK
#
#
 #-------PUT API Test------------------------
#@APITest @APITestPut
#Scenario: Verify that place is updated successfully using put place api 
#Given Add a place payload
#When user calls AddPlaceAPI with post http request
#Then API call got success with status code 200
#And Status in response body is OK
#When user calls updatePlaceAPI with put http request
#Then API call got success with status code 200
#And Status in response body is Address successfully updated 
#
 #--------GET API Test------------------------
#@APITest @APITestGet
#Scenario: Verify that user can get the place successfully using get place api 
#Given Add a place payload
#When user calls AddPlaceAPI with post http request
#Then API call got success with status code 200
#And Status in response body is OK
#When user calls getPlaceAPI with get http request
#Then API call got success with status code 200
#And Status in get response body should be correct
#
