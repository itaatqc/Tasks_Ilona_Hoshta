package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class LetterPage {
	private WebElement letterTo;
	private WebElement letterSubject;
	private WebElement letterText;
	private WebElement sendButton;

	public LetterPage() {
		this.letterTo = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='nb-23']"));
		this.letterSubject = ContextVisible.get().getVisibleWebElement(
				By.id("compose-subj"));
		this.letterText = ContextVisible.get().getVisibleWebElement(
				By.id("compose-send"));
		this.sendButton = ContextVisible.get().getVisibleWebElement(
				By.id("compose-submit"));
	}

	public WebElement getLetterTo() {
		return this.letterTo;
	}

	public WebElement getLetterSubject() {
		return this.letterSubject;
	}

	public WebElement getLetterText() {
		return this.letterText;
	}

	public WebElement getSendButton() {
		return this.sendButton;
	}

	public void sendLetter(StringBuilder forecast) {
		this.letterTo.click();
		this.letterTo.clear();
		this.letterTo.sendKeys("Atqcilona@yandex.ua");
		this.letterSubject.click();
		this.letterSubject.clear();
		this.letterSubject.sendKeys("Today's weather");
		this.letterText.click();
		this.letterText.clear();
		this.letterText.sendKeys(forecast);
	}

	public SentLetterPage sentButtonClick() {
		this.sendButton.click();
		return new SentLetterPage();
	}

}
