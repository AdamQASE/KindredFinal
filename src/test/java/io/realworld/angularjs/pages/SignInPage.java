package io.realworld.angularjs.pages;

import io.realworld.angularjs.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="(//fieldset/input[1])[2]")
    public WebElement username;

    @FindBy(xpath="(//fieldset/input[1])[3]")
    public WebElement password;

    @FindBy(xpath = "//form//fieldset/button")
    public WebElement signIn;



    @FindBy(xpath="(//fieldset/input[1])[2]")
    public WebElement InUsername;

    @FindBy(xpath="(//fieldset/input[1])[3]")
    public WebElement InPassword;

    @FindBy(xpath = "//form//fieldset/button")
    public WebElement InvSignIn;


    public void login(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        signIn.click();

    }


}
