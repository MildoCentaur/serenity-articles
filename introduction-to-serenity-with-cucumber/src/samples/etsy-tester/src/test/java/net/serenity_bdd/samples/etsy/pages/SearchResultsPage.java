package net.serenity_bdd.samples.etsy.pages;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends PageObject {

    public static final String SCROLL_TO_FILTERS = "$('a.red')[0].scrollIntoView(false);";


    public List<String> getResultTitles() {
        List<String> result = Lists.newArrayList();
        for (WebElementFacade webElementFacade : findAll(".card-title")) {
            result.add(webElementFacade.getAttribute("innerHTML").trim());
        }
        return result;
    }

    public void selectItem(int itemNumber) {
        List<WebElementFacade> listingCards = findAll(".listing-card");
        listingCards.get(itemNumber - 1).findElement(By.className("buyer-card")).click();
    }

    public void filterByType(String type) {
        showFilters();
        WebElementFacade form = $("#search-filter-reset-form");
        WebElementFacade optionButton = form.then(By.partialLinkText(type));
        optionButton.click();
    }

    public int getItemCount() {
        String resultCount = $(".result-count").getText()
                .replace("We found ","")
                .replace(" item","")
                .replace("s","")
                .replace("!","")
                .replace(",","")
                ;
        return Integer.parseInt(resultCount);
    }

    public Optional<String> getSelectedType() {
        List<WebElementFacade> selectedTypes = findAll("#search-filter-reset-form a.radio-label.strong");
        return (selectedTypes.isEmpty()) ? Optional.absent() : Optional.of(selectedTypes.get(0).getText());
    }

    public void showFilters() {
        evaluateJavascript(SCROLL_TO_FILTERS);
    }
}
