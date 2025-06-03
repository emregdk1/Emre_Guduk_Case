package pages;

import base.BaseTest;
import models.JobLeverModel;
import utils.ElementHelper;

public class JobLeverPage extends ElementHelper {

    //private final String checkJobsLever = "jobs.lever.co/useinsider";

    public void isLoadedJobsLever() {
        String checkJobsLever = BaseTest.Config.getString("checkJobsLever");
        shouldSee(checkJobsLever);

    }

    public void checkLeverFilterControlText() {
        checkIfElementExistLogCurrentText(JobLeverModel.leverFilterControlText);
    }
}
