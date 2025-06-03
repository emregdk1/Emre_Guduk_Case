package steps;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.annotations.Test;
import pages.*;
import utils.Screenshot;

public class InsiderTestSteps extends BaseTest {

    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    OpenPositionsPage openPositionsPage = new OpenPositionsPage();
    JobLeverPage jobLeverPage = new JobLeverPage();

    @Test(priority = 1)
    public void step1_goToHomePageAndNavigateToCareers() {
        test = extent.createTest("Step 1 - Home Page Navigation");
        try {
            homePage.goToHomePageUrl();
            test.pass("Navigated to Home Page URL");

            homePage.acceptCookies();
            test.pass("Accepted Cookies");

            homePage.isLoadedHomePageUrl();
            test.pass("Verified Home Page URL is Loaded");

            homePage.clickCompany();
            test.pass("Clicked on Company");

            homePage.clickCareers();
            test.pass("Clicked on Careers");

            homePage.isLoadedCareersPageUrl();
            test.pass("Verified Careers Page URL is Loaded");
        } catch (Exception e) {
            String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), "step1_HomePageNavigation");
            test.fail("Step 1 Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }

    @Test(priority = 2, dependsOnMethods = "step1_goToHomePageAndNavigateToCareers")
    public void step2_scrollAndGoToQA() {
        test = extent.createTest("Step 2 - Scroll and Navigate to QA Page");
        try {
            careersPage.scrollOurLocation();
            test.pass("Scrolled to Our Locations section");

            careersPage.scrollLifeAtInsider();
            test.pass("Scrolled to Life at Insider section");

            careersPage.goToCareersQAUrl();
            test.pass("Navigated to Careers QA Page");
        } catch (Exception e) {
            String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), "step2_ScrollAndGoToQA");
            test.fail("Step 2 Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }

    @Test(priority = 3, dependsOnMethods = "step2_scrollAndGoToQA")
    public void step3_verifyQAJobsPageAndSeeAllJobs() {
        test = extent.createTest("Step 3 - Verify QA Jobs Page and Click See All Jobs");
        try {
            qualityAssurancePage.isLoadedCareersQAUrl();
            test.pass("Verified QA Careers Page is Loaded");

            qualityAssurancePage.clickSeeAllQAJobs();
            test.pass("Clicked on See All QA Jobs");
        } catch (Exception e) {
            String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), "step3_VerifyQAJobsPage");
            test.fail("Step 3 Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }

    @Test(priority = 4, dependsOnMethods = "step3_verifyQAJobsPageAndSeeAllJobs")
    public void step4_filterAndSelectQAJobs() {
        test = extent.createTest("Step 4 - Filter and Select QA Jobs");
        try {
            openPositionsPage.isLoadedCareersOpenPositionsUrl();
            test.pass("Verified Careers Open Positions Page is Loaded");

            openPositionsPage.waitForTheQAText();
            test.pass("Waited for QA Text to appear");

            openPositionsPage.selectFilterQAJobs();
            test.pass("Selected QA Jobs Filter");

            openPositionsPage.waitForTheViewRoleHover();
            test.pass("Waited for View Role to be Hoverable");

            openPositionsPage.hoverViewRoleHover();
            test.pass("Hovered on View Role");

            openPositionsPage.clickViewRoleHover();
            test.pass("Clicked on View Role");
        } catch (Exception e) {
            String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), "step4_FilterAndSelectQAJobs");
            test.fail("Step 4 Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }

    @Test(priority = 5, dependsOnMethods = "step4_filterAndSelectQAJobs")
    public void step5_verifyJobLeverPage() {
        test = extent.createTest("Step 5 - Verify Job Lever Page");
        try {
            jobLeverPage.switchNewWindow();
            test.pass("Switched to New Window");

            jobLeverPage.isLoadedJobsLever();
            test.pass("Verified Job Lever Page is Loaded");

            jobLeverPage.checkLeverFilterControlText();
            test.pass("Checked Lever Filter Control Text");
        } catch (Exception e) {
            String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), "step5_VerifyJobLeverPage");
            test.fail("Step 5 Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }
}