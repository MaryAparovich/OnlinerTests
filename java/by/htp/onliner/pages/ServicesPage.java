package by.htp.library.onliner.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private WebDriverWait driverWait = driverWait = new WebDriverWait(driver, 200);

	@FindBy(xpath = "//*[@id=\'service-list\']/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]")
	private WebElement region;

			
	@FindBy(xpath = "//div[@class='service-offers__unit ng-scope']")
	private List<WebElement> offers;

	@FindBy(linkText = "Компьютерная помощь")
	private WebElement computerHelp;
	
	@FindBy(linkText = "Ритуальные услуги")
	private WebElement ritualServices;
	
	@FindBy(xpath = "//span[text()='Установка и настройка ПО']")
	private WebElement software;
	
	@FindBy(xpath = "//a[@class ='service-response__rating']")
	private List<WebElement> rating;
	
	@FindBy(xpath = "//a[@class ='service-offers__details-item service-offers__details-item_ok ng-binding ng-scope']")
	private List<WebElement> orders;
	
	public ServicesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void selectCity() {
		region.click();
	}

	public List<WebElement> getOffers() {
		List<WebElement> listOffers = offers;
		return listOffers;
	}
	
	public List<WebElement> getRating() {
		List<WebElement> listRating = rating;
		return listRating;
	}
	
	public List<WebElement> getOrders() {
		List<WebElement> listOrders = orders;
		return listOrders;
	}

	public void selectComputerHelp() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ritualServices).perform();
		computerHelp.click();
		software.click();

	}
}
