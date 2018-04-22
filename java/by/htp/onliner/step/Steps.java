package by.htp.library.onliner.step;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import by.htp.library.onliner.driver.DriverSingleton;
import by.htp.library.onliner.pages.MainPage;
import by.htp.library.onliner.pages.ServicesPage;

public class Steps {

	private WebDriver driver;
	private MainPage mainPage;
	private WebDriverWait driverWait;
	private ServicesPage servicesPage;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loadServices() {
		mainPage = new MainPage(driver);
		servicesPage = new ServicesPage(driver);
		mainPage.openPage();
		mainPage.openServices();
		servicesPage.selectCity();
	}

	public boolean isOffers() {
		servicesPage = new ServicesPage(driver);
		List<WebElement> elements = servicesPage.getOffers();
		if (elements.size() > 0) {
			return true;
		}
		return false;
	}
	
	public void checkOffersComputerHelp() {
		servicesPage = new ServicesPage(driver);
		servicesPage.selectComputerHelp();
	}

	public boolean isCommentsAndOrdersSuited(int commentsCountMoreThan,
			int ordersCountMoreEqualThan) {
		servicesPage = new ServicesPage(driver);
		List<WebElement> listRating = servicesPage.getRating();
		List<WebElement> listOrders = servicesPage.getOrders();
		List<WebElement> offers = servicesPage.getOffers();
		for (int i = 0; i < offers.size(); i++) {
			String offerRatingText = listRating.get(i).getText();
			String offerOrderText = listOrders.get(i).getText();
			String offerRatingArray[] = offerRatingText.split(" ");
			String offerOrderArray[] = offerOrderText.split(" ");

			int countCommments = Integer.valueOf(offerRatingArray[0]);
			int countOrders = Integer.valueOf(offerOrderArray[1]);

			if (countCommments > commentsCountMoreThan && countOrders >= ordersCountMoreEqualThan) {
				System.out.println(countCommments + " " + countOrders);
				return true;
			}
		}
		return false;
	}
}
