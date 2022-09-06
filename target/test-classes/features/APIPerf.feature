#Feature: Place Validation


# --------GET API Test------------------------
#Scenario: Verify that user can get the place successfully using get place api 
#Given Add a place payload
#When user calls AddPlaceAPI with post http request
#Then API call got success with status code 200
#And Status in response body is OK
#When user calls getPlaceAPI with get http request
#Then API call got success with status code 200
#And Status in get response body should be correct