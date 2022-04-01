package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  WebDriver driver = null;
  By usernameInput = By.name("uName");
  By passwordInput = By.name("pass");
  By loginButton = By.name("login");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setUsernameTextBox(String inputUname) {
    driver.findElement(usernameInput).sendKeys(inputUname);
  }

  public void setPasswordTextBox(String inputPass) {
    driver.findElement(passwordInput).sendKeys(inputPass);
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).sendKeys(Keys.RETURN);
  }
}
