package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
  WebDriver driver = null;
  By usernameInput = By.name("uName");
  By passwordInput = By.name("pass");
  By createButton = By.name("create");
  By homeRedirect = By.name("home");

  public CreateAccountPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setUsernameTextBox(String inputUname) {
    driver.findElement(usernameInput).sendKeys(inputUname);
  }

  public void setPasswordTextBox(String inputPass) {
    driver.findElement(passwordInput).sendKeys(inputPass);
  }

  public void clickCreateButton() {
    driver.findElement(createButton).sendKeys(Keys.RETURN);
  }

  public void clickHomeRedirect() {
    driver.findElement(homeRedirect).click();
  }
}
