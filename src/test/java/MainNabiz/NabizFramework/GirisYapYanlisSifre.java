package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapYanlisSifre extends BaseNabiz{
	
	@Parameters({"gecerli_mail"})
	@Test
	public void yanlis_sifre(String gecerli_mail) throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		String uretilenSifre = utilities.randomPassword(10);
		
		gundem.profilim.click();
		profil.girisYap.click();
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.eposta_girme_alani.click();
		giris.eposta_girme_alani.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.sifre_girme_alani.click();
		giris.sifre_girme_alani.sendKeys(uretilenSifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.normal_Giris.click();
		
		String actualMessage = "Geçerli bir şifre girin";
		String toastMessage = giris.uyari_mesaji.getAttribute("name");
		assertEquals(actualMessage, toastMessage);
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
