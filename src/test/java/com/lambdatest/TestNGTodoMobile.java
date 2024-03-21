package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class TestNGTodoMobile {

//    private AppiumDriver<MobileElement> driver;

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username ="ritamg";
        String authkey="acess_key";
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Galaxy Note20");
        ltOptions.put("platformVersion", "11");
        ltOptions.put("isRealMobile", true);
        capabilities.setCapability("lt:options", ltOptions);

        driver = new RemoteWebDriver(new URL("https://" + "shubhamr" + ":" + "dl8Y8as59i1YyGZZUeLF897aCFvIDmaKkUU1e6RgBmlgMLIIhh" + hub), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://dev.web.torrid.com/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button[class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
        Thread.sleep(15000);
        driver.findElement(By.cssSelector("img[class='w-100 lazy img-fluid d-block d-md-none py-2 loaded']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("img[class='first-image img-fluid']")).click();


        Thread.sleep(9000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
// Execute the script with the specified coordinates
        String xpath = "//*[@id=\"slick-slide00\"]/div/div/div[1]/a/picture/img";
        String script = "var element = document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "if (element !== null) {" +
                "  element.style.transform = 'scale(2)';" +
                "} else {" +
                "  return 'Element not found';" +
                "}";
        Object result = js.executeScript(script, xpath);
        if ("Element not found".equals(result)) {
            System.out.println("The element was not found with the provided XPath: " + xpath);
        } else {
            System.out.println("Transform applied.");
        }

        String xpath1 = "//*[@id=\"slick-slide00\"]/div/div/div[1]/a/picture/img"; // Your XPath
        String script1 = "var element = document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "return element ? element.style.transform : '';";
        String transformValue = (String) js.executeScript(script1, xpath1);

// Output the extracted value
        System.out.println("Transform value: " + transformValue);

        Thread.sleep(15000);
        driver.quit();
        }






    }

