package ua.net.itlabs.hw7.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.net.itlabs.hw7.pages.ToDoMVC;
import ua.net.itlabs.hw7.pages.ToDoMVC.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CustomConditions {


    public static ExpectedCondition<WebElement> listElementWithText(final By elementsListLocator, final String text) {

        return new ExpectedCondition<WebElement>() {
            private List<String> actualTexts;
            private List<WebElement> elementsList;

            public WebElement apply(WebDriver driver) {
                //actualTexts = new ArrayList<>();
                elementsList = driver.findElements(elementsListLocator);
//                    for (WebElement element : elementsList) {
//                        actualTexts.add(element.getText());
//                    }
                for (int i = 0; i < elementsList.size(); i++) {
                    if (elementsList.get(i).getText().contains(text)) {
                        return elementsList.get(i);
                    }
                }
                return null;
            }

            public String toString() {
                return String.format("\nElement by text %s is not found by locator %s", text, elementsListLocator);
            }
        };
    }



    public static ExpectedCondition<List<WebElement>> visibleTextsOf(final By elementsListlocator, final String... expectedTexts) {
        if (expectedTexts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        return new ExpectedCondition<List<WebElement>>() {
            private List<String> actualTexts;
            private List<WebElement> elementsList;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<>();
                elementsList = driver.findElements(elementsListlocator);
                for (WebElement element : elementsList) {
                    if(element.isDisplayed()){
                    actualTexts.add(element.getText());}
                }
                if (actualTexts.size() != expectedTexts.length) {
                    return null;
                }
                for (int i = 0; i < actualTexts.size(); i++) {
                    if (!actualTexts.get(i).contains(expectedTexts[i])) {
                        return null;
                    }
                }
                return elementsList;
            }

            public String toString() {
                return String.format("\nFor list with locator %s\nexpected texts are: %s \nwhile actual texts are: %s", elementsListlocator, Arrays.asList(expectedTexts), actualTexts);
            }
        };
    }
}
