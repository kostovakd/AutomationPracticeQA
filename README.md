# Automation Practice QA

## Requirements
- Selenium Standalone Server: https://www.selenium.dev/downloads/
- ChromeDriver: https://sites.google.com/a/chromium.org/chromedriver/
- Maven: https://maven.apache.org/install.html

## Setup

Run the Selenium Standalone Server

```
java -jar -Dwebdriver.chrome.driver=chromedriver selenium-server-standalone-3.141.59.jar
```


Install all dependencies

```
cd AutomationPracticeQA
mvn install -DskipTests
```


## Run tests
```
mvn -Dtest=DressesWebTest test
```


## Design
Tests use Carina Framework: https://www.carina-core.io/ that has built-in Selenium in it.

Each page component has been separated to its own `Page` class under `src.main.java.pages`.

Current pages are the following ones:
- `APAbstractPage`: an abstract page extended from the Carina framework that each page uses. Handles urls and opening of a page.
- `DressDetailPage`: a page for every individual dress.
- `DressesPage`: a page for listing all dresses.
- `HomePage`: the home page where the comes the first time.

Tests are run directly from `DressesWebTest` class under `src.test.java.com.accenture.demo`.

Authors: Kristina Kostova