package util;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {

    WebDriver driver;
    WebDriverWait wait ;
    Actions action;

    public ElementUtil() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        this.action = new Actions(driver);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public WebElement presenceElement(By key) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(key));
            return element;
        }catch (Exception ignored) {
            Assert.fail("Element bulunamadi");
            return null;
        }
    }
    public List<WebElement> presenceElements(By key) {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
            return elements;
        }catch (Exception ignored) {
            Assert.fail("Element bulunamadi");
            return null;
        }
    }

    public WebElement findElementClickableShort(By key) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(key));
            return element;
        }catch (Exception ignored) {
            return null;
        }
    }

    public void click(By key) {
        try {
            findElementClickableShort(key).click();
        }catch (Exception e){
            WebElement element = presenceElement(key);
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
            wait.until(ExpectedConditions.elementToBeClickable(key)).click();
        }
    }
    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception ignored) {
            Assert.fail("Element bulunamadi");
        }
    }


    public void checkElementVisible(By key) {
        presenceElement(key);
        try {
            try {
                wait.until(ExpectedConditions.visibilityOf(presenceElement(key)));
            }catch (Exception ignored){
                WebElement element = presenceElement(key);
                JavascriptExecutor j = (JavascriptExecutor) driver;
                j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
                wait.until(ExpectedConditions.visibilityOf(presenceElement(key)));
            }
        }catch (Exception ignored) {
            Assert.fail("Element bulunamadi");
        }
    }

    public void sendKey(By key, String string) {
        try {
            WebElement element = presenceElement(key);
            element.sendKeys(string);
        } catch (Exception ignored) {
            Assert.fail("Element bulunamadi");
        }
    }

    public String elementGetText(By by) {
        String text = null;
        try {
            presenceElement(by);
            text = driver.findElement(by).getText();
            return text;
        } catch (Exception ignored) {
            Assert.fail();
            return null;
        }
    }
    public String getTextElementsWithIndex(By by, int number) {
        WebElement element = presenceElements(by).get(number);
        return elementGetText(element);
    }

    public int elementGetTextNumber(By by) {
        int number = 0;
        try {
            presenceElement(by);
            number = Integer.parseInt(driver.findElement(by).getText());
            return number;
        } catch (Exception ignore) {
            Assert.fail();
            return number;
        }

    }

    public void checkElementGetTextNumber(By by, int number) {
        Assert.assertEquals(elementGetTextNumber(by), number);
    }

    public void checkElementGetText(By key,String text) {
        presenceElement(key);
        Assert.assertEquals(elementGetText(key), text);
    }

    public String elementGetText(WebElement element) {
        try {
            WebElement returnElement = wait.until(ExpectedConditions.visibilityOf(element));
            return returnElement.getText();
        } catch (Exception ignored) {
            Assert.fail("Element bulunamadı veya texti cekilemedi");
            return null;
        }
    }

    public WebElement elementWithTextFromTheElements(By key, String text) {
        List<WebElement> elements = presenceElements(key);
        boolean check = false;
        WebElement returnElement = null;
        for (WebElement element : elements) {
            if(elementGetText(element).equals(text)){
                check = true;
                returnElement = element;
                break;
            }
        }
        if(!check || returnElement == null){
            Assert.fail("Elementin texti bulunamadi");
        }
        return returnElement;
    }

    public void swipeRightSlider(By key, int x, int y){
        action.dragAndDropBy(presenceElement(key), x, y).perform();
    }
    public void swipeLeftSlider(By key, int x, int y){
        action.dragAndDropBy(presenceElement(key), x, y).perform();
    }

    public boolean isTimeInRange(String time, String startTime, String endTime) {
        return (time.compareTo(startTime) >= 0) && (time.compareTo(endTime) <= 0);
    }

    public void getTextEqualsChildElementsFromElements(By key, String text) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
        boolean check = false;
        for (WebElement parentElement : elements) {
            List<WebElement> childElements = parentElement.findElements(By.xpath(".//*"));
            for (WebElement childElement : childElements) {
                if(childElement.getText().equals(text)){
                    click(childElement);
                    check = true;
                    break;
                }
            }
            if(check == true){
                break;
            }
        }
        Assert.assertTrue(check);
    }


}
