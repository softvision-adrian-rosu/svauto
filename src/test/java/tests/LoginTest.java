package tests;

<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.commons.lang3.StringUtils;
=======
>>>>>>> First commit
=======
import org.apache.commons.lang3.StringUtils;
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static helpers.Utilities.getPropertyFromAppProp;

public class LoginTest extends BaseTest {

  private DashboardPage dashboardPage = null;
  private LoginPage loginPage = null;
  private MyAccountPage myAccountPage = null;

  private String email;
  private String password;
  private String invalidEmail;
  private String invalidPassword;
  public static final String EMPTY_EMAIL_MESSAGE = "An email address required.";
  public static final String EMPTY_PASSWORD_MESSAGE = "Password is required.";
  public static final String FAILED_AUTHENTICATION_MESSAGE = "Authentication failed.";

  public LoginTest(){
    this.email = getPropertyFromAppProp("email");
    this.password = getPropertyFromAppProp("password");
    this.invalidEmail = getPropertyFromAppProp("invalidEmail");
    this.invalidPassword = getPropertyFromAppProp("invalidPassword");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    this.emptyEmail = StringUtils.EMPTY;
    this.emptyPassword = StringUtils.EMPTY;
=======
    this.emptyEmail = "";
    this.emptyPassword = "";
>>>>>>> First commit
=======
    this.emptyEmail = StringUtils.EMPTY;
    this.emptyPassword = StringUtils.EMPTY;
>>>>>>> Added StringUtils.EMPTY in LoginTest and new element in DashboardPage
=======
>>>>>>> LoginTest update with constants,
  }

  @BeforeMethod
  void beforeMethod(){
    this.dashboardPage = new DashboardPage(getDriver());
    this.loginPage = new LoginPage(getDriver());
    this.myAccountPage = new MyAccountPage(getDriver());
  }
  //Happy flow login
<<<<<<< HEAD
<<<<<<< HEAD
  @Test
=======
  @Test(priority = 5)
>>>>>>> First commit
=======
  @Test
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
  public void testLogin(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, password);
    this.myAccountPage.verify();
  }
  //Negative testing flow
<<<<<<< HEAD
<<<<<<< HEAD
  @Test
=======
  @Test(priority = 3)
>>>>>>> First commit
=======
  @Test
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
  public void testInvalidEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(invalidEmail, password);
<<<<<<< HEAD
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

=======
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed(), FAILED_AUTHENTICATION_MESSAGE);
  }

<<<<<<< HEAD
  @Test(priority = 4)
>>>>>>> First commit
=======
  @Test
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
  public void testInvalidPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
    this.loginPage.login(email, invalidPassword);
<<<<<<< HEAD
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed(),FAILED_AUTHENTICATION_MESSAGE);
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

=======
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

<<<<<<< HEAD
  @Test(priority = 1)
>>>>>>> First commit
=======
  @Test
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
  public void testEmptyEmail(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
<<<<<<< HEAD
    this.loginPage.login(emptyEmail, password);
<<<<<<< HEAD
<<<<<<< HEAD
=======
    this.loginPage.login(StringUtils.EMPTY, password);
>>>>>>> LoginTest update with constants,
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed(), EMPTY_EMAIL_MESSAGE );
  }

  @Test
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

=======
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
  }

<<<<<<< HEAD
  @Test(priority = 2)
>>>>>>> First commit
=======
  @Test
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
  public void testEmptyPassword(){
    this.dashboardPage.open();
    this.dashboardPage.verify();
    this.dashboardPage.clickLoginButton();

    this.loginPage.verify();
<<<<<<< HEAD
    this.loginPage.login(email, emptyPassword);
<<<<<<< HEAD
<<<<<<< HEAD
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
=======
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());

    this.loginPage.verify();
>>>>>>> First commit
=======
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed());
>>>>>>> Updated LoginTest loginPage.verify() position and DashboardPage
=======
    this.loginPage.login(email, StringUtils.EMPTY);
    this.loginPage.verify();
    Assert.assertTrue(this.loginPage.errorMessage().isDisplayed(), EMPTY_PASSWORD_MESSAGE);
>>>>>>> LoginTest update with constants,
  }
}
