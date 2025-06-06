package pages;

import base.BaseTest;
import models.QualityAssuranceModel;
import utils.ElementHelper;

public class QualityAssurancePage extends ElementHelper {

    public void isLoadedCareersQAUrl() {
        String checkQAPage = BaseTest.Config.getString("checkQAPage");
        shouldSee(checkQAPage);
    }

    public void clickSeeAllQAJobs() {
        clickElement(QualityAssuranceModel.seeAllQAJobs);
    }
}
