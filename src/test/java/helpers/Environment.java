package helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static helpers.Utilities.getPropertyFileContent;
import static helpers.Utilities.getPropertyValue;

public class Environment {
  private static WebDriver driver;
  private static Browsers browser;
  private static String url;

  private final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver";
  private final String FIREFOX_DRIVER_PATH = "./src/main/resources/geckodriver";
  protected final String APP_FILE = "./app.properties";

  @BeforeClass
  @Parameters({"browser", "url"})
  public void openBrowser(String browser, String url) {
    if (browser == null || StringUtils.isNotEmpty(url)){
      setBrowser();
      openBrowser();
    } else {
      this.browser = Browsers.stringToEnum(browser);
      openBrowser();
    }
    if (url != null && StringUtils.isNotEmpty(url)) {
      this.url = url;
      this.driver.get(this.url);
    } else {
      setURL();
      this.driver.get(url);
    }
  }

  @AfterClass(alwaysRun = true)
  public void cleanUp() {
    if (this.driver != null) {
      this.driver.quit();
    }
  }

  private void openBrowser(){
    switch (this.browser){
      case CHROME:
        initChrome();
        break;
      case FIREFOX:
        initFirefox();
        break;
      default:
        try {
          throw new Exception("Unknown browser!");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
  }

  private void initChrome(){
    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    this.driver = new ChromeDriver();
    this.driver.manage().window().maximize();
  }

  private void initFirefox(){
    System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
    this.driver = new FirefoxDriver();
    this.driver.manage().window().maximize();
  }

  public static WebDriver getDriver(){
    return driver;
  }

  private void setBrowser(){
    this.browser = Browsers.stringToEnum(getPropertyValue(getPropertyFileContent(APP_FILE), "browser"));
  }

  private void setURL(){
    this.url = getPropertyValue(getPropertyFileContent(APP_FILE), "url");
  }
}