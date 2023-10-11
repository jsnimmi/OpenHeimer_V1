# OPPENHEIMER Project
Project Name: THE OPPENHEIMER PROJECT

Application URL: http://localhost:9997/login

About Project:
This OPPENHEIMER project is 
- Enable Clerks to populate a list of working class heroes to the system
- Enable BookKeepers to retrieve the payable taxation for each working class and application process is described.

Technologies Used:
- Java
- Selenium
- REST Assured
- Cucumber

Test Data:
Login credentials pass through feature file.

How to run scripts:
We can run test scripts using tag name or feature level / Scenario level
Ex: @OppenHeimer
 
To start the application you can run the following commands in your terminal
Install and Start the docker and run spring boot command before launch the app/url.
1. docker-compose -f {path-to-this-docker-file}/local-docker-compose.yml up -d
2. Verify that your database is up and running. The credentials are a. Url:
   jdbc:mysql://localhost:3306/testdb
   b. Username: user
   c. Password: userpassword
3. Run java -Dspring.profiles.active=prd -jar
   {path-to-this-jar}/OppenheimerProjectDev.jar
4. Verify that you can access the login page via http://localhost:9997/login
5. Login credentials for various roles:
   Role: Username / Password
   Clerk: clerk / clerk
   Book: Keeper bk / bk

Report:
Go to below path and open cucumber-report.
C:\Users\jsnim\IdeaProjects\OpenHeimerProjectNir\test-output

Project done by: Nirmala