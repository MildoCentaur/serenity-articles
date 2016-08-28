package net.serenity_bdd.samples.etsy.features.steps.serenity;

import java.util.Map;

import net.serenity_bdd.samples.etsy.pages.CartPage;
import net.serenity_bdd.samples.etsy.pages.ItemDetailsPage;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class CarSteps {

	public static final double ZERO_VALUE = 0.0;
	ItemDetailsPage detailsPage;
	CartPage cartPage;

	@Step
	public void adds_item_to_cart() {
		detailsPage.addToCartItem();
	}

	@Step
	public void should_see_the_total_and_tax_price() {
		Map<String, String> billingItems = cartPage.getBillingItems();
		assertThat(billingItems).containsKey("total");
		Double total = Double.parseDouble(billingItems.get("total").split(" ")[1]);
		assertThat(total).isGreaterThan(0.0);
		assertThat(billingItems).containsKey("tax");
		String tax = billingItems.get("tax").split(" ")[1];
		assertThat(Double.parseDouble(tax)).isEqualTo(ZERO_VALUE);
	}
}
