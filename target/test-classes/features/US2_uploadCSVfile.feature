@OppenHeimer @UI
Feature: Verify the process of CSV fileupload in OppenHeimer application

  @ClerkDashboard
  Scenario: Validate the process of invalid CSV fileupload in OpenHeimer-clerk dashboard
    Given Launch the browser and navigate to OpenHeimer Working class Hero system
    And user enters username "clerk", password "clerk" and login to working system
    And select Add Hero on the Clerk dashboard
    When User select the Choose File area to upload the "Invalid" file
    Then validate the response