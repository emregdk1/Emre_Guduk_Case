package steps;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageDeneme;
import utils.Screenshot;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageIsLoaded() {
        try {

            //Step1
            HomePageDeneme homePage = new HomePageDeneme(driver);
            homePage.goToHomePageUrl();
            homePage.acceptCookies();
            Assert.assertTrue(homePage.isLoadedHomePageUrl(), "Home page did not load correctly.");

            //Step2
            homePage.clickCompany();
            homePage.clickCareers();
            homePage.isLoadedCareersPageUrl();

            //Step3
            homePage.scrollOurLocation();
            homePage.scrollLifeAtInsider();

            //Step4
            homePage.goToCareersQAUrl();
            Assert.assertTrue(homePage.isLoadedCareersQAUrl(), "Careers QA page did not load correctly.");

            //Step5
            homePage.clickSeeAllQAJobs();
            Assert.assertTrue(homePage.isLoadedCareersOpenPositionsUrl(), "Careers Open Positions page did not load correctly.");

            //Step6
            homePage.waitForTheQAText();

            //Step7
            homePage.selectFilterQAJobs();

            //Step9
            homePage.waitForTheViewRoleHover();

            //Step10
            homePage.hoverViewRoleHover();

            //Step11
            homePage.clickViewRoleHover();

            //Step12
            homePage.switchNewWindow();

            //Step13
            Assert.assertTrue(homePage.isLoadedJobsLever(), "Jobs Lever page did not load correctly.");

            //Step14
            homePage.checkLeverFilterControlText();

        } catch (Exception e) {
            Screenshot.takeScreenshot(driver, "homepage_load_failure");
            throw e;
        }

    }
}
