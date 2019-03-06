package helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Helper class for working with the page's elements
 */
public class WebElementHelper {
  private static final Logger LOG = Logger.getLogger(Class.class.getName());

  public static void setFieldValue(WebElement element, String text){
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  public static boolean isElementDisplayed(WebElement element) {
    try {
      if (element != null && element.isDisplayed()) {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  public static boolean areVisible(WebElement... elements) {
    final List<WebElement> webElements = Arrays.asList(elements);
    final List<WebElement> elementsNotVisible = new ArrayList<>();

    webElements.forEach(webElement -> {
      if (!isElementDisplayed(webElement)) {
        elementsNotVisible.add(webElement);
      }
    });

    if (!elementsNotVisible.isEmpty()) {
      LOG.warning(String.format("The following elements are not visible in page: %s", elementsNotVisible));
    }
    return elementsNotVisible.isEmpty();
  }

  public static void inputEmail(WebElement element){
    int length = 5;
    int length2 = 5;
    int length3 = 3;
    boolean letters = true;
    boolean numbers = true;
    boolean numbersTwo = false;
    element.click();
    element.clear();
    String generateStringOne = RandomStringUtils.random(length, letters, numbers);
    String generateStringTwo = RandomStringUtils.random(length2, letters, numbers);
    String generateStringThree = RandomStringUtils.random(length3, letters, numbersTwo);
    element.sendKeys(generateStringOne + "@" + generateStringTwo + "." + generateStringThree);
  }

  public static void inputLetters(WebElement element){
    int length = 10;
    boolean letters = true;
    boolean numbers = false;
    element.click();
    element.clear();
    String generateString = RandomStringUtils.random(length, letters, numbers);
    element.sendKeys(generateString);
  }

  public static void inputNumbers(WebElement element){
    String generateNumbers = RandomStringUtils.randomNumeric(0, 9);
    element.sendKeys(generateNumbers);
  }
}
