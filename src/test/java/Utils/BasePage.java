package Utils;



/*This is base class having selenium webdriver based functionality- which interacts with browser*/

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        WebElement element= new WebElement() {
            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return null;
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }

            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }
        };
    }



  protected  Set<String> getUrl(By Locator, String attribute) {
      Set<String> UrlList = new HashSet<String>();

      List<WebElement> webElements = driver.findElements(Locator);
      for (WebElement element : webElements) {
          UrlList.add(   element.getAttribute(attribute));
      }
      return  UrlList;

    }
    protected void clickOn(By Locator) {

       // driver.findElement(Locator).click();
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.elementToBeClickable(Locator) ).click();

    }
    protected void clickOn(By parent, By child ) {

        driver.findElement(parent).findElement(child).click();
    }

    protected String getText(By Locator) {
       return driver.findElement(Locator).getText();

    }
    protected void CloseAlert(By Locator) {
        WebDriverWait wait = new WebDriverWait(driver,3);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)).click();

        }catch (Exception e)
        { }
    }

    protected void enterText(By Locator, String ValueToBeEnter) {
    //    driver.findElement(Locator).sendKeys(ValueToBeEnter);
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(Locator) ).sendKeys(ValueToBeEnter);

    }
    protected void clearText(By Locator) {
        //    driver.findElement(Locator).sendKeys(ValueToBeEnter);
       /* WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(Locator) ).clear();
*/
        driver.findElement(Locator).clear();

    }

}
