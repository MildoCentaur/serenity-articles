package net.serenity_bdd.samples.etsy.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

	public Map<String, String> getBillingItems() {
		List<WebElement> rows = find(By.className("multi-shop-cart-payment")).findElements(By.tagName("tr"));
		Map<String,String> map = new HashMap<>();
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if(cells.size()==2){
				map.put(cells.get(0).getText().toLowerCase(),cells.get(1).getText());
			}
		}
		return map;
	}
}
