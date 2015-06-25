package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class InboxPage {
	private WebElement messagesSubject;
	private WebElement checkbox;

	public InboxPage() {
		this.messagesSubject = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[2]/div/span[2]/span/a/span[1]/span/span[1]"));
		this.checkbox = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div[3]/div/div/div[3]/div[2]/div/label/input"));
	}

	public WebElement getMessagesSubject() {
		return messagesSubject;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public DeletingLetterPage checkboxClick() {
		this.checkbox.click();
		return new DeletingLetterPage();
	}

}
