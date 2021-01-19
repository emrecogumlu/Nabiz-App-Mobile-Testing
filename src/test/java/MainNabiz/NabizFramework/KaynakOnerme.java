package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KaynakOnerme extends BaseNabiz{
	
	@Test
	public void kaynak_oner() 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		Utilities utilities = new Utilities(driver);
		
		gundem.profilim.click();
		utilities.scrollIntoText("Kaynak Önerin");
		
		profil.kaynak_onerin.click();
		
		assertEquals(profil.onerecegini_yaz.isDisplayed(), true);
		
	}
	
	@BeforeMethod
	public void BeforeMethod() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("NabizApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void AfterMethod() 
	{
		service.stop();
	}
	
}
