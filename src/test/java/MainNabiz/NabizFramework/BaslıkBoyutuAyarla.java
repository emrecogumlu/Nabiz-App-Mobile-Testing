package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.BaslikBoyutuPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaslıkBoyutuAyarla extends BaseNabiz{
	
	@Test
	public void baslik_boyutu_ayarla() 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		BaslikBoyutuPage baslik_boyutu = new BaslikBoyutuPage(driver);
		
		gundem.profilim.click();
		profil.baslik_boyut.click();
		
		assertEquals(Boolean.parseBoolean(baslik_boyutu.small.getAttribute("checked")), true);
		baslik_boyutu.large.click();
		assertEquals(Boolean.parseBoolean(baslik_boyutu.large.getAttribute("checked")), true);
		baslik_boyutu.small.click();
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
