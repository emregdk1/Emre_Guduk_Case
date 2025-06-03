package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.ElementHelper;
import utils.ExtentManager;
import utils.ReadProperties;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseTest {
    private ElementHelper elementHelper;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static ResourceBundle FilterParam;
    public static ResourceBundle Config;

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupDriver(@Optional("chrome") String driverType) {
        readProperties();
        elementHelper = new ElementHelper();
        elementHelper.setUp(driverType);
    }

    static {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeSuite(alwaysRun = true)
    public void setUpExtent() {
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownExtent() {
        if (extent != null) {
            extent.flush();
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            logger.info("Driver will be closed");
            elementHelper.tearDown();
        }
    }

    public static void readProperties() {
        FilterParam = ReadProperties.readProp("FilterParam.properties");
        Config = ReadProperties.readProp("Config.properties");
    }

    public static WebDriver getDriver() {
        return ElementHelper.getDriver();
    }
}