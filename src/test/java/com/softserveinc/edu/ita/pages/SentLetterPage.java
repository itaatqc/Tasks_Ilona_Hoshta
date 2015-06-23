package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class SentLetterPage {
	private WebElement checkLetters;

	public SentLetterPage() {
		this.checkLetters = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='js-page']/div/div[5]/div/div[3]/div/div[2]/div[3]/div/div/div[2]/a[3]/span[1]"));
	}

	public WebElement getCheckLetters() {
		return this.checkLetters;
	}

	public InboxPage checkLettersClick() {
		this.checkLetters.click();
		return new InboxPage();
	}
}
