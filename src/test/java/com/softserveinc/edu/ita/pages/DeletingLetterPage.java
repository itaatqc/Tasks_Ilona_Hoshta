package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class DeletingLetterPage {
	private WebElement delete;
	private WebElement logout;
	// TODO: move selectors to a separate file
	public DeletingLetterPage() {
		this.delete = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='js-page']/div/div[5]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/a[8]"));
		this.logout = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='nb-1']/span[2]"));
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getLogout() {
		return logout;
	}

	public DeletingLetterPage deleteClick() {
		this.delete.click();
		return new DeletingLetterPage();
	}

	public ExitPage logoutClick() {
		this.logout.click();
		return new ExitPage();
	}

}
