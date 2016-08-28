package net.serenity_bdd.samples.etsy.pages;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://www.etsy.com")
public class HomePage extends PageObject {


//    @FindBy(linkText = "Search")
//    WebElement searchButton;

    public void searchFor(String keywords) {
        $("#search-query").type(keywords);
        Serenity.takeScreenshot();
        findAll(".as-suggestion").get(0).click();
    }
}
