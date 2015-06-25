package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class LoginMailPage {
	private WebElement loginName;
	private WebElement password;
	private WebElement loginButton;

	public LoginMailPage() {
		this.loginName = ContextVisible.get().getVisibleWebElement(
				By.name("login"));
		this.password = ContextVisible.get().getVisibleWebElement(
				By.name("passwd"));
		this.loginButton = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='js']/body/div[1]/div[1]/div[1]/form/div[4]/span/button"));
	}

	public WebElement getLoginName() {
		return this.loginName;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public WebElement getLoginButton() {
		return this.loginButton;
	}

	public MailPage loginMail() {
		this.loginName.click();
		this.loginName.clear();
		this.loginName.sendKeys("Atqcilona@yandex.ua");
		this.password.click();
		this.password.clear();
		this.password.sendKeys("Qwerty123");
		this.loginButton.click();
		return new MailPage();
	}

}