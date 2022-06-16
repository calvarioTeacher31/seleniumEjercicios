package org.example.pageobjects.bars;

import org.example.base.BasePage;
import org.example.models.UrlModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class FooterPage extends BasePage {
    private final By twitterButton = By.xpath("//a[text()='Twitter']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");
    private final By linkedinButton = By.xpath("//a[text()='LinkedIn']");

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(twitterButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying step two page UI elements");

        log.info("Verifying twitter button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(twitterButton), "twitter is not displayed");

        log.info("Verifying twitter button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(facebookButton), "twitter is not displayed");

        log.info("Verifying twitter button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(linkedinButton), "twitter is not displayed");
    }

    public void verifySocialMediaLinks(HashMap<String, UrlModel> map) {
        log.info("Verifying twitter button is clickable");
        softAssert.assertTrue(verifyIsEnabled(twitterButton), "twitter button is not clickable");

        log.info("Verifying facebook button is clickable");
        softAssert.assertTrue(verifyIsEnabled(facebookButton), "facebook button is not clickable");

        log.info("Verifying linkedin button is clickable");
        softAssert.assertTrue(verifyIsEnabled(linkedinButton), "linkedin button is not clickable");
        softAssert.assertAll();

        log.info("Verifying twitter link is correct");
        softAssert.assertEquals(getHref(twitterButton), map.get("twitter").getUrl());

        log.info("Verifying facebook link is correct");
        softAssert.assertEquals(getHref(facebookButton), map.get("facebook").getUrl());

        log.info("Verifying linkedin link is correct");
        softAssert.assertEquals(getHref(linkedinButton), map.get("linkedin").getUrl());
        softAssert.assertAll();
    }
}
