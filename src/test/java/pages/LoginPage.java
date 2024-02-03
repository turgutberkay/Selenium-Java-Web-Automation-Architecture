package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import util.ElementUtil;

public class LoginPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By loginForm = By.cssSelector("[data-testid='membership-signin-form']");
    private final By ePostaInput = By.cssSelector("[data-testid='membership-signin-email-input']");
    private final By passwordInput = By.cssSelector("[data-testid='membership-signin-password-input']");
    private final By loggedInMemberShip = By.cssSelector("[data-testid='membership-loggedinuser-name']");
    private final By loginButton = By.cssSelector("[data-testid='membership-signin-submit-button']");



    public void checkLoginForm() {
        elementUtil.checkElementVisible(loginForm);
    }

    public void writeToEPosta(String mail) {
        elementUtil.sendKey(ePostaInput,mail);
    }

    public void writeToPassword(String password) {
        elementUtil.sendKey(passwordInput,password);
    }

    public void checkLoggedInMemberShip() {
        elementUtil.checkElementVisible(loggedInMemberShip);
    }

    public void clickLoginButton() {
        elementUtil.click(loginButton);
    }






}
