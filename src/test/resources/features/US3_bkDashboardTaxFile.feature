@OppenHeimer @UI
Feature: Verify the UI process of the BK-OppenHeimer project application

  @BKDashboard
  Scenario: Validate the process of OpenHeimer-BK application
    Given Launch the browser and navigate to OpenHeimer Working class Hero system
    And user enters username "bk", password "bk" and login to working system
   # And select Generate Tax Relief file on the bk dashboard
   # Then validate the downloaded Tax Relief file "C:\Users\jsnim\Downloads" "tax_relief_file"