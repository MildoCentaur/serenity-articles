package net.serenity_bdd.samples.etsy.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenity_bdd.samples.etsy.features.steps.serenity.BuyerSteps;
import net.serenity_bdd.samples.etsy.features.steps.serenity.CarSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Mildo on 8/21/16.
 */
public class AddItemsToCart {

	@Steps
	CarSteps car;

	@When("I add the item to the shopping cart")
	public void addToCartSelectedItem() {
		car.adds_item_to_cart();
	}

	@Then("I should see the total price including tax")
	public void shouldSeeTotalAndTaxPrice() {
		car.should_see_the_total_and_tax_price();
	}
}
