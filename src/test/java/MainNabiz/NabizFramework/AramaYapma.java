package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GundemPage;
import PageObjects.HaberSayfasıPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;


public class AramaYapma extends BaseNabiz{
	
	@Test
	public void arama_yap()
	{
		GundemPage gundem = new GundemPage(driver);
		HaberSayfasıPage haber_sayfasi = new HaberSayfasıPage(driver);
		
		gundem.gundemim.click();
		gundem.arama_butonu.click();
		
		String myString = "deneme";
		gundem.arayacagini_yaz.sendKeys(myString);
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(960, 1850)).perform();
		
		gundem.gundem_haberler.get(0).click();
		String haber_baslikString=haber_sayfasi.haber_basligi.getText();
		
		assertEquals(haber_baslikString.contains(myString), true);
		
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
