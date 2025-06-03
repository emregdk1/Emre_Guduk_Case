package models;

import org.openqa.selenium.By;

public class OpenPositionsModel {

    public static final By qualityAssuranceText = By.xpath("//span[@title='Quality Assurance']");
    public static final By selectLocationButton = By.xpath("//select[@name='filter-by-location']");
    public static final By selectDepartmentButton = By.xpath("//select[@name='filter-by-department']");
    public static final By viewRoleHover = By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[2]");
    public static final By viewRoleClick = By.xpath("(//a[contains(@class,'btn btn-navy rounded')])[3]");
}
