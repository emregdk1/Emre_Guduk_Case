
# Emre Guduk Case - Test Automation Framework

This repository contains an end-to-end Test Automation Framework built with **Java 23**, **Selenium**, and **Rest Assured** for UI and API testing, structured using **TestNG**.

## 📚 Assignment Overview

The goal of this project is to automate the testing of the **Insider** website by validating various pages and functionalities.

### ✅ Test Scenarios

- Open Insider homepage and verify it loads successfully.
- Navigate to the **Careers** page.
- Verify the **Career Opportunities** section.
- Filter open positions for **Istanbul, Turkey**.
- Validate position details (title, location, department).
- Capture screenshots at each step to ensure visual validation.

Automation is done in three modes:
1. **Basic Steps** (`InsiderTestSteps.java`): Regular functional validation.
2. **With Screenshots** (InsiderTestStepsScreenshot.java): Capture a screenshot only when a verification fails.
3. **Cross-Browser Support:** The test implementation supports parametric execution across multiple browsers (e.g., Chrome, Firefox). By passing the desired browser type as a parameter (e.g., via command line, testng.xml, or environment variable), tests can dynamically initialize the corresponding WebDriver, enabling flexible and scalable cross-browser testing.

# UI Test Automation – Java + Selenium

This repository contains a UI test automation example that meets the specified requirements for cross-browser execution, failure-based screenshot capture, and Page Object Model (POM) compliance.

---

## ✅ Requirements Fulfilled

### ✔️ 1. No BDD Framework Used
- The project is implemented using **Java + Selenium**.
- No BDD frameworks (e.g., Cucumber, Quantum, Codeception) are used.

### ✔️ 2. Screenshot on Failure
- Screenshots are captured **only when a test step fails**.
- This feature helps quickly identify failures without unnecessary image clutter.

### ✔️ 3. Cross-Browser Execution
- Supports both **Chrome** and **Firefox**.
- Browser type can be passed **as a parameter** (e.g., via system property or command-line argument):

## 🚀 Technologies Used

- **Java 23**
- **Maven** - Project Management & Dependency Management
- **Selenium WebDriver** - UI Test Automation
- **TestNG** - Test Management Framework
- **Rest Assured** - API Test Automation
- **Extent Reports** - Test Reporting

## 🛠️ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/your-repo/emre-guduk-case.git
cd emre-guduk-case
```

2. **Install dependencies**

Make sure Maven is installed on your machine:

```bash
mvn clean install
```

3. **Run Tests**

- Run all tests:

```bash
mvn test
```

- Run specific test classes:

```bash
mvn -Dtest=ClassName test
```

Example:

```bash
mvn -Dtest=InsiderTestStepsScreenshot test
```

Or directly through your IDE (e.g., IntelliJ IDEA, Eclipse) using TestNG support.

## 📝 Writing Tests

- **UI Tests** follow the **Page Object Model (POM)** pattern.
- **API Tests** are implemented using **Rest Assured**.
- Test methods are annotated using **TestNG** annotations like `@Test`, `@BeforeClass`, `@AfterClass` for lifecycle management.

Sample Test Structure:

```java
@Test
public void verifyCareerPageNavigation() {
    HomePage homePage = new HomePage(driver);
    homePage.navigateToCareers();
    Assert.assertTrue(careersPage.isCareerSectionVisible());
}
```

## 📄 Reporting

After test execution, reports are generated under the `test-output/` directory by **Extent Reports**.

## 🔧 Configurations

Test configurations like URLs, browser settings, and environment variables can be managed through properties files under the `src/test/resources` directory.