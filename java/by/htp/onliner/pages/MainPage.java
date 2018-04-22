package by.htp.library.onliner.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://onliner.by";
	private WebDriverWait driverWait;

	@FindBy(xpath = "//span[text()='Услуги']")
	private WebElement servicesSection;

	@FindBy(xpath = "//a[text()='Ремонт компьютерной техники']")
	private WebElement computerRepairSection;

	public MainPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}
	
	public void openServices() {
		servicesSection.click();
		computerRepairSection.click();

	}
}
