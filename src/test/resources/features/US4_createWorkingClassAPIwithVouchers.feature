@OppenHeimer
Feature:  Create Working Class Hero with vouchers through  API

  Background: Setting-up API Base URL
    Given with api base url as "http://localhost:9997/api"

  Scenario Outline: Test API with vouchers for valid and invalid data and verify response code and message
    Given with request end point as "/v1/hero/vouchers"
    And with request body  as below
      | name   | gender   | birthDate   | deathDate   | browniePoints   | salary   | taxpaid   | voucherName   | voucherType   |
      | <name> | <gender> | <birthDate> | <deathDate> | <browniePoints> | <salary> | <taxpaid> | <voucherName> | <voucherType> |
    When with method as "post"
    Then verify status is <responseCode>
    Then verify error message in response is "<errorMsg>"

    Examples:
      | name  | gender | birthDate | deathDate | browniePoints | salary | taxpaid | responseCode | errorMsg                                      | voucherName | voucherType |
      | Roja1 | MALE   | today-2   | today-1   | 10            | 10     | 1       | 500          | null                                          | VOUCHER 12  | TRAVEL      |
      | Roja  | FEMALE | today+2   | null      | 10            | 10     | 1       | 400          | null                                          | VOUCHER 14  | TRAVEL      |
      | 1234  | FEMALE | today-2   | null      | 10            | 10     | 1       | 400          | Invalid name                                  | VOUCHER 15  | TRAVEL      |
      | Roja  | FEMALE | today-2   | null      | 10            | -10    | 1       | 400          | Salary must be greater than or equals to zero | VOUCHER 16  | TRAVEL      |
      | Roja  | FEMALE | today-2   | null      | 10            | 10     | -1      | 400          | must be greater than or equal to 0            | VOUCHER 17  | TRAVEL      |
      | Roja  | NO     | today-2   | null      | 10            | 10     | -1      | 400          | Invalid gender                                | VOUCHER 18  | TRAVEL      |

  Scenario Outline: Test API with vouchers for valid scenario and verify response code
    Given with request end point as "/v1/hero/vouchers"
    And with request body  as below
      | name   | gender   | birthDate   | deathDate   | browniePoints   | salary   | taxpaid   | voucherName   | voucherType   |
      | <name> | <gender> | <birthDate> | <deathDate> | <browniePoints> | <salary> | <taxpaid> | <voucherName> | <voucherType> |
    When with method as "post"
    Then verify status is <responseCode>

    Examples:
      | name      | gender | birthDate | deathDate | browniePoints | salary | taxpaid | responseCode | voucherName | voucherType |
      | Roja      | MALE   | today-2   | null      | 10            | 10     | 1       | 200          | VOUCHER 11  | TRAVEL      |
      | Roja Rani | FEMALE | today-5   | null      | null          | 10     | 1       | 200          | VOUCHER 13  | TRAVEL      |
      | MaxLength | FEMALE | today-5   | null      | null          | 10     | 1       | 200          | VOUCHER 13  | TRAVEL      |