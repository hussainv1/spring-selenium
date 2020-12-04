package com.udemy.spring.springselenium.page.google;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.udemy.spring.springselenium.page.Base;

@Component
public class SearchComponent extends Base {
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(name = "btnK")
	private List<WebElement> searchBtns;
	
	public void search(final String keyword) {
		this.searchBox.sendKeys(keyword);
		this.searchBox.sendKeys(Keys.TAB);
		this.searchBtns
						.stream()
						.filter((e) -> e.isDisplayed() && e.isEnabled())
						.findFirst()
						.ifPresent((e) -> e.click());
	}

	// until - Repeatedly applies this instance's input value to the given function till false or null is  returned
	/**
	 * Repeatedly applies this instance's input value to the given function until one of the following occurs: 
	1.the function returns neither null nor false
	2.the function throws an unignored exception
	3.the timeout expires
	4.the current thread is interrupted

	 */
	
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.searchBox.isDisplayed());
	}

}
