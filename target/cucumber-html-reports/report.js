$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/placeValidationAPI.feature");
formatter.feature({
  "name": "Place Validation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that place is added successfully using add place api",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionPost"
    }
  ]
});
formatter.step({
  "name": "Add a place payload",
  "keyword": "Given "
});
formatter.match({
  "location": "apiStepdef.add_a_place_payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls AddPlaceAPI with post http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_AddPlaceAPI_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.api_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in response body is OK",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_response_body_is_OK()"
});
formatter.result({
  "status": "passed"
});
});