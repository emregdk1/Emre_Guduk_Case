package steps;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import pages.web.CareersPage;

import java.util.HashMap;
import java.util.Map;

import static pages.web.CareersPage.*;

public class CareersSteps extends BaseSteps {


    public void careersControl(DataTable table) {
        logger.info("Entered. Parameters; table: {}", table);
        for (Map<String, String> data : table.asMaps(String.class, String.class)) {
            if (data.containsKey("LocationControl") && data.containsKey("LifeAtInsiderControl")) {
                String locationControl = data.get("LocationControl");
                checkLocation();
                waitByMilliSeconds(2000);
                String lifeAtInsiderControl = data.get("LifeAtInsiderControl");
                checkLifeAtInsider();
            }
        }
    }

    public void checkLocation() {
        logger.info("Entered.");
        scrollByJs(CareersPage.OUR_LOCATIONS_TEXT.getLocator());
        checkIfElementExistLogCurrentText(CareersPage.OUR_LOCATIONS_TEXT.getLocator());
    }

    public void checkLifeAtInsider() {
        logger.info("Entered.");
        scrollByJs(CareersPage.LIFE_AT_INSIDER_TEXT.getLocator());
        checkIfElementExistLogCurrentText(CareersPage.LIFE_AT_INSIDER_TEXT.getLocator());
    }

    public enum FilterOption {
        SEE_ALL_QA_JOBS
    }

    private final HashMap<String, Runnable> hashMapLogOut = new HashMap<>();
    private HashMap<String, Runnable> hashMap = new HashMap<>();

    public void FilterHashMap(DataTable option) {
        for (Map<String, String> data : option.asMaps(String.class, String.class)) {
            logger.info("Entered. Parameters; table:{}\n", option);
            hashMap.put(String.valueOf(CareersSteps.FilterOption.SEE_ALL_QA_JOBS), () -> filterProcess(option,
                    data.get("Select Location"),
                    SELECT_LOCATION_BUTTON.getLocator(),
                    data.get("Select Department"),
                    SELECT_DEPARTMENT_BUTTON.getLocator()));
        }
    }

    public void filterOption(DataTable option) {
        logger.info("Entered. Parameters; option:{}", option);
        for (Map<String, String> data : option.asMaps(String.class, String.class)) {
            FilterHashMap(option);
            if (data.containsKey("Filter Positions")) {
                Runnable locator = hashMap.get(data.get("Filter Positions").toUpperCase());
                if (locator != null) {
                    locator.run();
                } else {
                    logger.info("Invalid Filter Positions");
                }
            }
        }
    }


    public void filterProcess(DataTable option, String selectLocationText, By selectLocation, String selectDepartmentText, By selectDepartment) {
        logger.info("Entered.");
        for (Map<String, String> data : option.asMaps(String.class, String.class)) {

            if (data.containsKey("Select Location")) {
                selectDropDown(selectLocationText, selectLocation);
            }
            if (data.containsKey("Select Department")) {
                selectDropDown(selectDepartmentText, selectDepartment);
            }
        }
    }

    public void selectDropDown(String text, By by) {
        logger.info("Entered.");
        text = BaseTest.FilterParam.getString(text + "_Selection").trim();
        selectTextFromDropDown(text, by);
    }
}
