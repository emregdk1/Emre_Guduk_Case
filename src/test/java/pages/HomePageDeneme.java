package pages;

import base.BaseTest;
import constants.Constants;
import locaters.Locaters;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static base.BaseTest.action;
import static constants.Constants.DEFAULT_MAX_ITERATION_COUNT;
import static constants.Constants.DEFAULT_MILLISECOND_WAIT_AMOUNT;

public class HomePageDeneme {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String homePageUrl = "https://useinsider.com/";
    private final String careersQAUrl = "https://useinsider.com/careers/quality-assurance/";

    public HomePageDeneme(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomePageUrl() {
        this.driver.get(homePageUrl);
    }

    public boolean isLoadedHomePageUrl() {
        return wait.until(ExpectedConditions.urlContains("useinsider.com"));
    }

    public void acceptCookies() {
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(Locaters.cookieAcceptButton));
            cookieBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Cookie accept button not displayed.");
        }
    }

    public void clickCompany() {
        scrollByJs(Locaters.companyButton);
        driver.findElement(Locaters.companyButton).click();
        checkIfElementExistLogCurrentText(Locaters.companyButton);
    }

    public void clickCareers() {
        driver.findElement(Locaters.careersButton).click();
    }

    public boolean isLoadedCareersPageUrl() {
        return wait.until(ExpectedConditions.urlContains("useinsider.com/careers/"));
    }

    public void scrollOurLocation() {
        scrollByJs(Locaters.ourLocationText);
        checkIfElementExistLogCurrentText(Locaters.ourLocationText);
    }

    public void scrollLifeAtInsider() {
        scrollByJs(Locaters.lifeAtInsiderText);
        checkIfElementExistLogCurrentText(Locaters.lifeAtInsiderText);
    }

    public void goToCareersQAUrl() {
        this.driver.get(careersQAUrl);
    }

    public boolean isLoadedCareersQAUrl() {
        return wait.until(ExpectedConditions.urlContains("useinsider.com/careers/quality-assurance/"));
    }

    public void clickSeeAllQAJobs() {
        driver.findElement(Locaters.seeAllQAJobs).click();
    }

    public boolean isLoadedCareersOpenPositionsUrl() {
        return wait.until(ExpectedConditions.urlContains("useinsider.com/careers/open-positions/?department=qualityassurance"));
    }

    public void waitForTheQAText() {
        waitForTheElement(Locaters.qualityAssuranceText);
    }

    public void selectFilterQAJobs() {
        selectDropDown("Location", Locaters.selectLocationButton);
        selectDropDown("Department", Locaters.selectDepartmentButton);
    }

    public void waitForTheViewRoleHover() {
        waitForTheElement(Locaters.viewRoleHover);
    }

    public void hoverViewRoleHover() {
        waitByMilliSeconds(3000);
        hoverAndClick(driver.findElement(Locaters.viewRoleHover), driver.findElement(Locaters.viewRoleClick));
    }

    public void clickViewRoleHover() {
        driver.findElement(Locaters.viewRoleHover).click();
    }

    public boolean isLoadedJobsLever() {
        return wait.until(ExpectedConditions.urlContains("jobs.lever.co/useinsider"));
    }

    public void checkLeverFilterControlText() {
        checkIfElementExistLogCurrentText(Locaters.leverFilterControlText);
    }

    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForTheElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForPageToCompleteState() {
        int counter = 0;
        int maxNoOfRetries = Constants.DEFAULT_MAX_ITERATION_COUNT;
        while (counter < maxNoOfRetries) {
            waitByMilliSeconds(Constants.DEFAULT_MILLISECOND_WAIT_AMOUNT);
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
            } catch (Exception ignored) {
            }
            counter++;
        }
    }

    public void scrollByJs(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript(
                "var element = arguments[0];" +
                        "var rect = element.getBoundingClientRect();" +
                        "window.scrollBy({ top: rect.top + window.scrollY - (window.innerHeight / 2), behavior: 'smooth' });",
                element
        );
        waitForPageToCompleteState();
    }

    public boolean isDisplayedBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void checkIfElementExistLogCurrentText(By locator) {
        int loopCount = 0;
        while (loopCount < DEFAULT_MAX_ITERATION_COUNT) {
            if (driver.findElements(locator).size() > 0) {
                String elementText = driver.findElement(locator).getText();
                System.out.println("Element found. Text: " + elementText);
                return;
            }
            loopCount++;
            waitByMilliSeconds(DEFAULT_MILLISECOND_WAIT_AMOUNT);
        }
        Assertions.fail("Element was not visible with the given locator: " + locator);
    }

    public void selectTextFromDropDown(String text, By by) {
        if (!isDisplayedBy((by))) {
            waitForTheElement(by);
        }
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectDropDown(String text, By by) {
        text = BaseTest.FilterParam.getString(text + "_Selection").trim();
        selectTextFromDropDown(text, by);
    }

    public void hoverAndClick(WebElement toHover, WebElement toClick) {
        action.moveToElement(toHover)
                .pause(Duration.ofMillis(300))
                .moveToElement(toClick)
                .click()
                .build()
                .perform();
    }

    public void switchNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
}