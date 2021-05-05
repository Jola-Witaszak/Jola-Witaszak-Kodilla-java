package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_COOKIE = "//button[@data-cookiebanner=\"accept_button\"]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//a[contains(@ajaxify, \"spotlight\")]";
    public static final String XPATH_BIRTHDAY = "//select[@id =\"day\"]";
    public static final String XPATH_MONTH_OF_BIRTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[contains(@name, \"_month\")]";
    public static final String XPATH_YEAR_OF_BIRTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[contains(@name, \"_year\")]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_ACCEPT_COOKIE)).isDisplayed());

        WebElement cookieAcceptButton = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIE));
        cookieAcceptButton.click();

        WebElement inputEmail = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        inputEmail.click();

        new WebDriverWait(driver, 10L).until(webDriver -> webDriver.findElement(By.xpath(XPATH_BIRTHDAY)));

        WebElement birthDay = driver.findElement(By.xpath(XPATH_BIRTHDAY));
        Select selectDay = new Select(birthDay);
        selectDay.selectByIndex(13);

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_MONTH_OF_BIRTH));
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByIndex(6);

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_YEAR_OF_BIRTH));
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByIndex(102);

        driver.close();
    }
}
