package by.htp.library.onliner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.onliner.step.Steps;

public class TestOnliner {
	private Steps steps;

	@BeforeMethod(groups = { "suite1" })
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = { "suite1" })
	public void checkOffersInTheCity() {
		steps.loadServices();
		Assert.assertTrue(steps.isOffers());
	}

	@Test(groups = { "suite2" })
	public void checkOffersInstallSoftware() {
		steps.loadServices();
		steps.checkOffersComputerHelp();
		Assert.assertTrue(steps.isOffers());
	}

	@Test(groups = { "suite3" })
	public void checkCountCommentsAndOrders() {
		steps.loadServices();
		steps.checkOffersComputerHelp();
		Assert.assertTrue(steps.isCommentsAndOrdersSuited(2, 3));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
