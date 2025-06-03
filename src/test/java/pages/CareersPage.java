package pages;

import base.BaseTest;
import models.CareersModel;
import utils.ElementHelper;

public class CareersPage extends ElementHelper {

    //private final String careersQAUrl = "https://useinsider.com/careers/quality-assurance/";

    public void scrollOurLocation() {
        scrollByJs(CareersModel.ourLocationText);
        checkIfElementExistLogCurrentText(CareersModel.ourLocationText);
    }

    public void scrollLifeAtInsider() {
        scrollByJs(CareersModel.lifeAtInsiderText);
        checkIfElementExistLogCurrentText(CareersModel.lifeAtInsiderText);
    }

    public void goToCareersQAUrl() {
        String careersQAUrl = BaseTest.Config.getString("careersQAUrl");
        goToUrl(careersQAUrl);
    }
}
