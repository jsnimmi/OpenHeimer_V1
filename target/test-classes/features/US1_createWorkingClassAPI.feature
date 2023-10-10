@OppenHeimer
Feature:  Create Working Class Hero through  API

  Background: Setting-up API Base URL
    Given with api base url as "http://localhost:9997/api"

  Scenario Outline: Test API for valid and invalid data and verify response code and message
    Given with request end point as "/v1/hero"
    And with request body  as below
      | name   | gender   | birthDate   | deathDate   | browniePoints   | salary   | taxpaid   |
      | <name> | <gender> | <birthDate> | <deathDate> | <browniePoints> | <salary> | <taxpaid> |

    When with method as "post"
    Then verify status is <responseCode>
    Then verify error message in response is "<errorMsg>"

    Examples:
      | name      | gender | birthDate | deathDate | browniePoints | salary | taxpaid | responseCode | errorMsg                                      |
      | Roja      | MALE   | today-2   | null      | 10            | 10     | 1       | 200          | null                                          |
      | Roja1     | MALE   | today-2   | today-1   | 10            | 10     | 1       | 500          | null                                          |
      | Roja Rani | FEMALE | today-5   | null      | null          | 10     | 1       | 200          | null                                          |
      | MaxLength | FEMALE | today-5   | null      | null          | 10     | 1       | 200          | null                                          |
      | Roja      | FEMALE | today+2   | null      | 10            | 10     | 1       | 400          | null                                          |
      | 1234      | FEMALE | today-2   | null      | 10            | 10     | 1       | 400          | Invalid name                                  |
      | Roja      | FEMALE | today-2   | null      | 10            | -10    | 1       | 400          | Salary must be greater than or equals to zero |
      | Roja      | FEMALE | today-2   | null      | 10            | 10     | -1      | 400          | must be greater than or equal to 0            |
      | Roja      | NO     | today-2   | null      | 10            | 10     | -1      | 400          | Invalid gender                                |