package pages;

import base.BaseTest;
import models.OpenPositionsModel;
import org.openqa.selenium.By;
import utils.ElementHelper;
public class OpenPositionsPage extends ElementHelper {

    public void isLoadedCareersOpenPositionsUrl() {
        String checkOpenPositionsPage = BaseTest.Config.getString("checkOpenPositionsPage");
        shouldSee(checkOpenPositionsPage);
    }

    public void waitForTheQAText() {
        waitForTheElement(OpenPositionsModel.qualityAssuranceText);
    }

    public void selectFilterQAJobs() {
        selectDropDown("Location", OpenPositionsModel.selectLocationButton);
        selectDropDown("Department", OpenPositionsModel.selectDepartmentButton);
    }

    public void waitForTheViewRoleHover() {
        waitForTheElement(OpenPositionsModel.viewRoleHover);
    }

    public void hoverViewRoleHover() {
        waitByMilliSeconds(3000);
        hoverAndClick(findElement(OpenPositionsModel.viewRoleHover), findElement(OpenPositionsModel.viewRoleClick));
    }

    public void clickViewRoleHover() {
        clickElement(OpenPositionsModel.viewRoleHover);
    }

    public void selectDropDown(String text, By by) {
        text = BaseTest.FilterParam.getString(text + "_Selection").trim();
        selectTextFromDropDown(text, by);
    }
}
