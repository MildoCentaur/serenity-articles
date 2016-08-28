package net.serenity_bdd.samples.etsy.features.steps.serenity;

import com.google.common.base.Optional;
import net.serenity_bdd.samples.etsy.pages.HomePage;
import net.serenity_bdd.samples.etsy.pages.ItemDetailsPage;
import net.serenity_bdd.samples.etsy.pages.SearchResultsPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BuyerSteps {

    public static final int EXPECTED_ZERO_ELEMENTS = 0;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ItemDetailsPage detailsPage;

    @Step
    public void opens_etsy_home_page() {
        homePage.open();
    }

    @Step
    public void searches_for_items_containing(String keywords) {
        homePage.searchFor(keywords);
    }

    @Step
    @Screenshots(afterEachStep = true)
    public void should_see_items_related_to(String keywords) {
        List<String> resultTitles = searchResultsPage.getResultTitles();
        assertThat(resultTitles.size()).isGreaterThan(EXPECTED_ZERO_ELEMENTS);

        //resultTitles.stream().forEach(title -> assertThat(title.toLowerCase()).contains(keywords.toLowerCase()));
    }
    @Step
    public void filters_results_by_type(String type) {
        searchResultsPage.filterByType(type);
    }

    public int get_matching_item_count() {
        return searchResultsPage.getItemCount();
    }

    @Step
    public void should_see_item_count(Matcher<Integer> itemCountMatcher) {
        itemCountMatcher.matches(searchResultsPage.getItemCount());
    }




    @Step
    public void selects_item_number(int number) {
        searchResultsPage.selectItem(number);
    }

    @Step
    public void should_see_matching_details(String searchTerm) {
        String itemName = detailsPage.getItemName();
        assertThat(itemName.toLowerCase()).contains(searchTerm);
    }

    @Step
    @Screenshots(afterEachStep = true)
    public void should_see_items_of_type(String type) {
        Optional<String> selectedType = searchResultsPage.getSelectedType();
        assertThat(selectedType.isPresent()).describedAs("No item type was selected").isTrue();
        assertThat(selectedType.get()).isEqualTo(type);
    }


}

