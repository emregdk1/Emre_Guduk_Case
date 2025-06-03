package models;

import org.openqa.selenium.By;

public class HomeModels {

    public static final By cookieAcceptButton = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    public static final By companyButton = By.xpath("(//a[@id='navbarDropdownMenuLink'])[5] | //a[text()='Company']");
    public static final By careersButton = By.xpath("//a[contains(@href,'careers')]");
}
