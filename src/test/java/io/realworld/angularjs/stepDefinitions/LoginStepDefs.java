package io.realworld.angularjs.stepDefinitions;

import io.cucumber.java.en.*;
import io.realworld.angularjs.pages.SignInPage;
import io.realworld.angularjs.utilities.BrowserUtils;
import io.realworld.angularjs.utilities.ConfigurationReader;
import io.realworld.angularjs.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {
    @Given("the user is in home page")
    public void the_user_is_in_home_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
    }

    @When("the user clicks sign in button")
    public void the_user_clicks_sign_in_button() {
        WebElement signInButton = Driver.get().findElement(By.xpath("//*[contains(@href, '#/login')]"));
        signInButton.click();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        String username = ConfigurationReader.get("Username");
        String password = ConfigurationReader.get("Password");

        SignInPage signInPage = new SignInPage();
        signInPage.login(username,password);

    }

    @Then("the user should be able to sign in")
    public void the_user_should_be_able_to_sign_in() {
        String text = "Your Feed";
        Assert.assertEquals(text, Driver.get().findElement(By.xpath("//div/div[2]//li[1]")).getText());

    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        String InUsername = ConfigurationReader.get("InvUsername");
        String InPassword = ConfigurationReader.get("InvPassword");
        SignInPage signInPage = new SignInPage();
        signInPage.login(InUsername,InPassword);
    }

    @Then("the user should not be able to sign in")
    public void the_user_should_not_be_able_to_sign_in() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Sign in — Conduit";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("the user is already signed in")
    public void the_user_is_already_signed_in() {
        System.out.println("The user is already signed in");
    }

    @When("the user clicks the settings button")
    public void the_user_presses_the_settings_button() throws InterruptedException {
        WebElement settings = Driver.get().findElement(By.xpath("//a[@href='#/settings']"));
        settings.click();

    }

    @Then("the user should navigate settings page")
    public void the_user_should_navigate_settings_page() throws InterruptedException {
        String actualText = "Your Settings";
        String expectedText = Driver.get().findElement(By.xpath("//h1[@class='text-xs-center']")).getText();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Done");
    }

    @When("the user enters text in short bio about you box")
    public void the_user_types_short_bio_in_short_bio_about_you_box() throws InterruptedException {

        WebElement bioBox = Driver.get().findElement(By.xpath("//textarea[@placeholder='Short bio about you']"));
        bioBox.sendKeys("I don't stop when I'm tired I stop when I'm done.");

    }

    @When("the user clicks the update settings button")
    public void the_user_presses_the_update_settings_button() {
        WebElement updateSettings = Driver.get().findElement(By.xpath("//button[normalize-space()='Update Settings']"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,250)", "");
        updateSettings.click();

        System.out.println("Click");
    }

    @Then("the text should appear under the username")
    public void theTextShouldAppearUnderTheUsername() {
        WebElement bioText = Driver.get().findElement(By.xpath("//p[@class='ng-binding']"));
        String text = "I don't stop when I'm tired I stop when I'm done.";
        Assert.assertTrue(text.contains("I don't stop when I'm tired I stop when I'm done."));
    }
}
