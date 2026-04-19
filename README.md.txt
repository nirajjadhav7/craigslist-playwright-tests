#  Craigslist Housing – UI Automation Tests

This project contains automated UI tests for the **Housing** section of:
https://madrid.craigslist.org/

The solution is built using **Java + Playwright + TestNG**, with **Allure reporting** for clear and detailed test results.

---

##  Scope of Testing

###  Default Sorting Options
Verify the following sorting options are available on page load:
- price ↑
- price ↓
- newest

###  Sorting Options After Search
After performing a search, verify additional options:
- price ↑
- price ↓
- newest
- relevant
- upcoming

###  Sorting Functionality
-  Results sorted by price ascending
-  Results sorted by price descending

---

##  Tech Stack

- Language: Java 17+
- Automation Framework: Playwright for Java
- Test Framework: TestNG
- Build Tool: Maven
- Reporting: Allure Reports

---

##  Framework Design

This project follows industry-standard design patterns:

### Page Object Model (POM)
- Separates UI logic from test logic
- Improves readability and maintainability

### Base Test Class
- Centralized browser setup and teardown
- Reduces duplication

### Utility Layer
- Playwright initialization handled via factory class

### Test Design
- Independent and reusable test cases
- Clear naming for readability

---

##  How to Run Tests

### Prerequisites
- Java 17+
- Maven installed

### Install dependencies
mvn clean install

### Run tests
mvn test

### Run using TestNG XML
mvn test -DsuiteXmlFile=testng.xml

---

##  Allure Reporting

### Generate results
mvn clean test

### Open report
mvn allure:serve

### Generate static report
mvn allure:report

---

##  Reporting Features

- Clear pass/fail status
- Step-level visibility
- Detailed failure logs
- Easy debugging via Allure dashboard

---

##  Test Scenarios

| Test Case           | Description                                  |
|--------------------|----------------------------------------------|
| Default Sorting    | Verify default sorting options               |
| Search Sorting     | Verify sorting options after search          |
| Price Ascending    | Validate ascending price order               |
| Price Descending   | Validate descending price order              |

---

##  Key Implementation Details

- Prices are dynamically extracted from listings
- Sorting is validated using assertions on collected values
- Selectors are maintained in Page Object classes
- Tests are designed to be independent and scalable

---

##  Future Enhancements

- Parallel execution with TestNG
- CI integration (GitHub Actions)
- Screenshot capture on failure
- Retry mechanism for flaky tests
- Cross-browser execution

---

## Assumptions

- Tests run against a live website; data may change
- UI updates may require selector adjustments
- Network latency may affect execution timing

---

## Author

Niraj Jadhav

---

## Submission

GitHub Repository:
https://github.com/nirajjadhav7/craigslist-playwright-tests