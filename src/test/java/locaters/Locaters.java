package locaters;

import org.openqa.selenium.By;

public class Locaters {

    public static final By cookieAcceptButton = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    public static final By companyButton = By.xpath("(//a[@id='navbarDropdownMenuLink'])[5] | //a[text()='Company']");
    public static final By careersButton = By.xpath("//a[contains(@href,'careers')]");
    public static final By ourLocationText = By.xpath("//section[@id='career-our-location']//h3");
    public static final By lifeAtInsiderText = By.xpath("//h2[text()='Life at Insider']");
    public static final By seeAllQAJobs = By.xpath("//a[contains(@class,'btn btn-outline-secondary')]");
    public static final By qualityAssuranceText = By.xpath("//span[@title='Quality Assurance']");
    public static final By selectLocationButton = By.xpath("//select[@name='filter-by-location']");
    public static final By selectDepartmentButton = By.xpath("//select[@name='filter-by-department']");
    public static final By viewRoleHover = By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[2]");
    public static final By viewRoleClick = By.xpath("(//a[contains(@class,'btn btn-navy rounded')])[3]");
    public static final By leverFilterControlText = By.xpath("//div[@class='posting-categories']");
}
