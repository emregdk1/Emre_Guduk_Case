package pages.web;

import org.openqa.selenium.By;
import pages.commen.BaseElement;

public class CareersPage extends WebMainPage{

    public static final String PAGE_NAME = "Careers Page";

    public static final BaseElement OUR_LOCATIONS_TEXT = new BaseElement(By.xpath("//section[@id='career-our-location']//h3"));
    public static final BaseElement LIFE_AT_INSIDER_TEXT = new BaseElement(By.xpath("//h2[text()='Life at Insider']"));
    public static final BaseElement SEE_ALL_QA_JOBS_BUTTON = new BaseElement(By.xpath("//a[contains(@class,'btn btn-outline-secondary')]"));
    public static final BaseElement QUALITY_ASSURANCE_TEXT = new BaseElement(By.xpath("//span[@title='Quality Assurance']"));
    public static final BaseElement SELECT_LOCATION_BUTTON = new BaseElement(By.xpath("//select[@name='filter-by-location']"));
    public static final BaseElement SELECT_DEPARTMENT_BUTTON = new BaseElement(By.xpath("//select[@name='filter-by-department']"));
    public static final BaseElement VIEW_ROLE_HOVER = new BaseElement(By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[2]"));
    public static final BaseElement VIEW_ROLE_BUTTON = new BaseElement(By.xpath("(//a[contains(@class,'btn btn-navy rounded')])[3]"));
    public static final BaseElement LEVER_FILTER_CONTROL_TEXT = new BaseElement(By.xpath("//div[@class='posting-categories']"));




    @Override
    public String getPageName() {
        return PAGE_NAME;
    }
}
