package pages;

import base.BaseTest;
import models.HomeModels;
import utils.ElementHelper;


public class HomePage extends ElementHelper {
    //private final String checkUrlCareers = "useinsider.com/careers/";
    //private final String checkUrlHomePage = "useinsider.com";

    public void goToHomePageUrl() {
        String homePageUrl = BaseTest.Config.getString("homePageUrl");
        goToUrl(homePageUrl);
    }

    public void isLoadedHomePageUrl() {
        String checkUrlHomePage = BaseTest.Config.getString("checkUrlHomePage");
        shouldSee(checkUrlHomePage);
    }


    public void acceptCookies() {
        clickElement(HomeModels.cookieAcceptButton);
    }

    public void clickCompany() {
        scrollByJs(HomeModels.companyButton);
        clickElement(HomeModels.companyButton);
        checkIfElementExistLogCurrentText(HomeModels.companyButton);
    }


    public void clickCareers() {
        clickElement(HomeModels.careersButton);
    }

    public void isLoadedCareersPageUrl() {
        String checkUrlCareers = BaseTest.Config.getString("checkUrlCareers");
        shouldSee(checkUrlCareers);
    }
}