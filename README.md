Document on setup and running the script:
I have written the assignment in two ways:
1.	Straightforward Test Case in Java using Selenium:
    Contains the Selenium code in a single class, written as a simple Java program.
    This approach is suitable for quick execution and understanding.
2.	TestNG with Page Object Model (POM):
    Implements a structured framework using TestNG and the POM design pattern.
    Separates test logic, page objects, and setup methods into distinct packages for scalability and maintainability.
Setup Instructions
1.	 Install Required Tools:
    Install Eclipse IDE.
    Install Java Development Kit (JDK) (ensure Java is added to your system's PATH).
    Download the appropriate ChromeDriver for your Chrome version.
2.	 Create a Maven Project:
    Open Eclipse and create a new Maven project.
    Add the necessary dependencies in the pom.xml file:

<dependencies>
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>4.24.0</version>
	</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.10.1</version>
			<scope>test</scope>
		</dependency>
</dependencies>

3.	 Create Packages and Classes:
•	Under src/test/java, create the following packages and classes:
Straightforward Approach:
    Create a package: fitPeoAssignment.
  	Create a class inside the package: Assignment.
o	This class contains the Selenium code to execute the test case.
  Run the script as a Java application.
  Page Object Model with TestNG:
	Create the following packages:
  pages: Contains classes for page object models.
	Classes:
  HomePage: Contains locators and methods for interacting with the homepage.
  RevenueCalculatorPage: Contains locators and methods for the revenue calculator page.
  testBase: Contains reusable setup and teardown logic.
	Class:
  BaseClass: Manages WebDriver initialization and cleanup.
  testCases: Contains the TestNG test case logic.
	Class:
  FitPeo: Implements TestNG annotations for test execution.
Running the Script
Straightforward Test Case
1.	Open the Assignment class in the fitPeoAssignment package.
2.	Execute the class:
    Right-click the class file → Run As → Java Application.
TestNG with Page Object Model
1.	Open the testCases.FitPeo class.
2.	Run using TestNG:
    Right-click the class file → Run As → TestNG Test.	


