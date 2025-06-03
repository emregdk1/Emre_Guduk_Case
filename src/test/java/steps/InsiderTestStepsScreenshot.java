package steps;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.annotations.Test;
import pages.*;
import utils.Screenshot;

public class InsiderTestStepsScreenshot extends BaseTest {

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
            embedScreenshot("Navigated to Home Page URL");

            homePage.acceptCookies();
            embedScreenshot("Accepted Cookies");

            homePage.isLoadedHomePageUrl();
            embedScreenshot("Verified Home Page URL is Loaded");

            homePage.clickCompany();
            embedScreenshot("Clicked on Company");

            homePage.clickCareers();
            embedScreenshot("Clicked on Careers");

            homePage.isLoadedCareersPageUrl();
            embedScreenshot("Verified Careers Page URL is Loaded");
        } catch (Exception e) {
            failWithScreenshot("step1_HomePageNavigation", e);
        }
    }

    @Test(priority = 2, dependsOnMethods = "step1_goToHomePageAndNavigateToCareers")
    public void step2_scrollAndGoToQA() {
        test = extent.createTest("Step 2 - Scroll and Navigate to QA Page");
        try {
            careersPage.scrollOurLocation();
            embedScreenshot("Scrolled to Our Locations section");

            careersPage.scrollLifeAtInsider();
            embedScreenshot("Scrolled to Life at Insider section");

            careersPage.goToCareersQAUrl();
            embedScreenshot("Navigated to Careers QA Page");
        } catch (Exception e) {
            failWithScreenshot("step2_ScrollAndGoToQA", e);
        }
    }

    @Test(priority = 3, dependsOnMethods = "step2_scrollAndGoToQA")
    public void step3_verifyQAJobsPageAndSeeAllJobs() {
        test = extent.createTest("Step 3 - Verify QA Jobs Page and Click See All Jobs");
        try {
            qualityAssurancePage.isLoadedCareersQAUrl();
            embedScreenshot("Verified QA Careers Page is Loaded");

            qualityAssurancePage.clickSeeAllQAJobs();
            embedScreenshot("Clicked on See All QA Jobs");
        } catch (Exception e) {
            failWithScreenshot("step3_VerifyQAJobsPage", e);
        }
    }

    @Test(priority = 4, dependsOnMethods = "step3_verifyQAJobsPageAndSeeAllJobs")
    public void step4_filterAndSelectQAJobs() {
        test = extent.createTest("Step 4 - Filter and Select QA Jobs");
        try {
            openPositionsPage.isLoadedCareersOpenPositionsUrl();
            embedScreenshot("Verified Careers Open Positions Page is Loaded");

            openPositionsPage.waitForTheQAText();
            embedScreenshot("Waited for QA Text to appear");

            openPositionsPage.selectFilterQAJobs();
            embedScreenshot("Selected QA Jobs Filter");

            openPositionsPage.waitForTheViewRoleHover();
            embedScreenshot("Waited for View Role to be Hoverable");

            openPositionsPage.hoverViewRoleHover();
            embedScreenshot("Hovered on View Role");

            openPositionsPage.clickViewRoleHover();
            embedScreenshot("Clicked on View Role");
        } catch (Exception e) {
            failWithScreenshot("step4_FilterAndSelectQAJobs", e);
        }
    }

    @Test(priority = 5, dependsOnMethods = "step4_filterAndSelectQAJobs")
    public void step5_verifyJobLeverPage() {
        test = extent.createTest("Step 5 - Verify Job Lever Page");
        try {
            jobLeverPage.switchNewWindow();
            embedScreenshot("Switched to New Window");

            jobLeverPage.isLoadedJobsLever();
            embedScreenshot("Verified Job Lever Page is Loaded");

            jobLeverPage.checkLeverFilterControlText();
            embedScreenshot("Checked Lever Filter Control Text");
        } catch (Exception e) {
            failWithScreenshot("step5_VerifyJobLeverPage", e);
        }
    }
    private void embedScreenshot(String message) {
        String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), message.replaceAll("\\s+", "_"));
        test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    private void failWithScreenshot(String screenshotName, Exception e) {
        String screenshotPath = Screenshot.takeScreenshot(BaseTest.getDriver(), screenshotName);
        test.fail("Test Failed: " + e.getMessage(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        throw new RuntimeException(e);
    }
}