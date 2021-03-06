package MainNabiz.NabizFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapGoogle extends BaseNabiz{
	
	
	@Test
	public void google_ile_Gir() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		gundem.profilim.click();
		profil.girisYap.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.google_Giris.click();
		giris.devam_et.click();
		
		utilities.scrollIntoText("Oturumu kapat");
		profil.oturumu_Kapat1.get(1).click();
		profil.oturumu_Kapat2.click();
		
		
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
