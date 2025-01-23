package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.web.CareersPage;
import steps.BaseSteps;
import steps.CareersSteps;
import utils.ClassList;


public class CareersStepDefinitions extends BaseSteps {


    private final BaseSteps baseSteps = ClassList.getInstance().get(BaseSteps.class);
    public final CareersSteps careersSteps = ClassList.getInstance().get(CareersSteps.class);
    protected Logger logger = LoggerFactory.getLogger(getClass());



    @Given("Navigate to the Career page and validate")
    public void navigateToCareerPageAndValidate(DataTable table) {
        logger.info("Entered. Parameters; table: \n{}", table);
        careersSteps.careersControl(table);
    }

    @Given("Navigate to the See all QA jobs page")
    public void navigateToSeeAllQaJobsPage() {
        logger.info("Entered.");
        baseSteps.clickElement(CareersPage.SEE_ALL_QA_JOBS_BUTTON.getLocator());
    }

    @Given("Select Filter QA jobs")
    public void filterOption(DataTable table) {
        logger.info("Entered.");
        careersSteps.filterOption(table);
    }

    @Given("Wait for the QUALITY ASSURANCE text to load")
    public void waitForTheQAText() {
        logger.info("Entered.");
        baseSteps.waitForTheElement(CareersPage.QUALITY_ASSURANCE_TEXT.getLocator());
    }

    @Given("Wait for the View Role button to load")
    public void waitForTheViewRoleButton() {
        logger.info("Entered.");
        baseSteps.waitForTheElement(CareersPage.VIEW_ROLE_HOVER.getLocator());
    }

    @Given("Hover over the view role button")
    public void hoverViewRoleButton() {
        logger.info("Entered.");
        waitByMilliSeconds(3000);
        baseSteps.hoverElement(findElement(CareersPage.VIEW_ROLE_HOVER.getLocator()));
    }

    @Given("Click the View Role button to load")
    public void clickViewRoleButton() {
        logger.info("Entered.");
        baseSteps.clickElement(CareersPage.VIEW_ROLE_BUTTON.getLocator());
    }

    @Given("Verify the Lever Filter Control Text")
    public void leverFilterControlText() {
        logger.info("Entered.");
        baseSteps.checkIfElementExistLogCurrentText(CareersPage.LEVER_FILTER_CONTROL_TEXT.getLocator());
    }
}
