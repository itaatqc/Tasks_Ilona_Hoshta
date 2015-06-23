package com.softserveinc.edu.ita.tasks;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.ita.tools.BrowserRepository;
import com.softserve.edu.ita.tools.IBrowser;
import com.softserve.edu.ita.tools.WebDriverUtils;
import com.softserveinc.edu.ita.pages.DeletingLetterPage;
import com.softserveinc.edu.ita.pages.ExitPage;
import com.softserveinc.edu.ita.pages.InboxPage;
import com.softserveinc.edu.ita.pages.LetterPage;
import com.softserveinc.edu.ita.pages.LoginMailPage;
import com.softserveinc.edu.ita.pages.MailPage;
import com.softserveinc.edu.ita.pages.SentLetterPage;
import com.softserveinc.edu.ita.pages.StartPage;
import com.softserveinc.edu.ita.pages.YandexStartPage;

public class Weather {
	final static Logger logger = Logger.getLogger(Weather.class);

	@DataProvider
	public Object[][] firstTest() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
				"http://www.yandex.ru/" } };
	}

	@Test(dataProvider = "firstTest")
	public void firstTest(IBrowser browser, String url) {

		// Load yandex.ru
		YandexStartPage yandexStartPage = StartPage.load(browser, url);

		// Get text of today's weather
		StringBuilder forecast = new StringBuilder();
		forecast.append(yandexStartPage.getWeather().getText() + "\n");
		forecast.append(yandexStartPage.getComment().getAttribute("title")
				.toString()+ "\n");
		forecast.append(yandexStartPage.getTempDay().getText() + "\n");
		forecast.append(yandexStartPage.getTempNight().getText() + "\n");
		logger.info("We have got a today's forecast");

		// Click on enterButton
		LoginMailPage loginMailPage = yandexStartPage.enterLinkClick();
		logger.info("We have clicked on enterButton");

		// Input login data and Enter into Email
		MailPage mailPage = loginMailPage.loginMail();
		logger.info("We have typed login data");

		// Click on writeLetter
		LetterPage letterPage = mailPage.writeLetterClick();
		logger.info("We have clicked on writeLetter");

		// Send forecast to email
		letterPage.sendLetter(forecast);
		SentLetterPage sentLetterPage = letterPage.sentButtonClick();
		logger.info("We have sent Letter!");

		// Check Inbox
		InboxPage inboxPage = sentLetterPage.checkLettersClick();
		Assert.assertEquals(inboxPage.getMessagesSubject().getText(),
				"Today's weather");

		// Return to previous state
		// Remove Letter
		DeletingLetterPage deletingLetterPage = inboxPage.checkboxClick();
		deletingLetterPage.deleteClick();
		logger.info("We have deleted Letter!");
		// Logout
		ExitPage exitPage = deletingLetterPage.logoutClick();
		exitPage.exitClick();
		logger.info("Logout");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}
}