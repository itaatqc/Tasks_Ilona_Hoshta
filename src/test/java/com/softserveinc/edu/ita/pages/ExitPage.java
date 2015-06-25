package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class ExitPage {
	private WebElement exit;

	public ExitPage() {
		this.exit = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='user-dropdown-popup']/div/div/div[8]/a"));
	}

	public WebElement getExit() {
		return exit;
	}

	public YandexStartPage exitClick() {
		this.exit.click();
		return new YandexStartPage(exit);
	}
}
