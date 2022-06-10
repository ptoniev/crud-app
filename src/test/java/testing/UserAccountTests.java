package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccountPage;
import pages.LoginPage;

public class UserAccountTests {
  private static WebDriver driver = null;

  public static void main(String[] args) throws InterruptedException {
    // createAccountTest();
    loginTest();
  }

  public static void createAccountTest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    CreateAccountPage signUpPageObj = new CreateAccountPage(driver);
    // Loading the Create account page
    driver.get("http://localhost:8080/create-account");
    // Setting the text in the username and password fields
    signUpPageObj.setUsernameTextBox("test1");
    signUpPageObj.setPasswordTextBox("test");
    // submitting form and creating account
    Thread.sleep(5000);

    signUpPageObj.clickCreateButton();

    Thread.sleep(5000);
    driver.quit();
  }

  public static void loginTest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    LoginPage loginPageObj = new LoginPage(driver);
    // Loading the home login page
    driver.get("http://localhost:8080");
    // Setting the text in username and password fields
    loginPageObj.setUsernameTextBox("test1");
    loginPageObj.setPasswordTextBox("test");
    // Submitting form with login button
    loginPageObj.clickLoginButton();
    System.out.println("Successful test! 2");
    Thread.sleep(5000);
    driver.quit();
  }

  public static void displayUserList() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    LoginPage loginPageObj = new LoginPage(driver);
    driver.get("http://localhost:8080");
    loginPageObj.clickListUsersButton();
    Thread.sleep(4000);
    driver.quit();
  }
}
