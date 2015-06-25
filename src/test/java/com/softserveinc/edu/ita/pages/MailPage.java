package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class MailPage {
	private WebElement writeLetter;

	public MailPage() {
		this.writeLetter = ContextVisible.get().getVisibleWebElement(
				By.partialLinkText("Написати"));
	}

	public WebElement getWriteLetter() {
		return this.writeLetter;
	}

	public LetterPage writeLetterClick() {
		this.writeLetter.click();
		return new LetterPage();
	}

}