Amplience Test

API and UI Testing Scenario
Test Framework is in Java language using Java libraries; RestAssured (for API Service) and Cucumber (for BDD styled), along with Maven as a build tool.

1. Overview
This API test uses Java as a main language with 'RestAssured' and 'Cucumber' libraries
And UI test uses Java with Selenium. 

Test will run according to feature files - which are stored under ./src/test/java/feature folder.

Outputs (Json, XML and html files) will be produced under ./target/cucumber-reports folder.


2. How to setup
Pull (clone) source code from Git as below command:
Note: Git client and Maven are required to setup and run

3. How to run tests and generate reports
There is a class "RunCukesTest", just run that class. And mention the tag **"@TestApi"** to run the API test.
and the tag **"@TestUI"** to run UI test.

Note: Since API and UI automation are done on same framework, We need to run the API test in headless mode. In **Hook** class uncomment the **"runInHeadlessBrowser()"** statement.

Once finished, there will be reports in ./target/cucumber-reports/* folder.

4. Where to find reports
JSON file: ./target/cucumber-reports/Cucumber.json
XML file: ./target/cucumber-reports/Cucumber.xml
HTML file: ./target/cucumber-reports/html/index.html

   



