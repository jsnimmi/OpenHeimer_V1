@OppenHeimer
Feature:  Create API to find working class hero owes money

  Background: Setting-up API Base URL
    Given with api base url as "http://localhost:9997/api"

  Scenario Outline: Test the number of vouchers in customer vouchers category API
    Given with request end point as "/v1/hero/owe-money?natid=1"
    When the method as "get"
    Then verify status is <responseCode>
   # And the JSON response should follow "C:\Users\jsnim\IdeaProjects\apiGovTech-UI-API-Merge\src\test\resources\schemas\voucherGategory.json"
    #Then verify response body in response is "<errorMsg>"

    Examples:
      | responseCode | errorMsg |
      | 400          | TRAVEL   |