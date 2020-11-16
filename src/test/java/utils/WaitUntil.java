package utils;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@RequiredArgsConstructor
public class WaitUntil
{
    private final WebDriver webDriver;

    public void waitUntilElementDisplay(WebElement webElement)
    {
        FluentWait<WebDriver> wait = new FluentWait<>(webDriver);
        wait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}











