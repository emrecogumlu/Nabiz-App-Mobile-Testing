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

public class GirisYapStandartGiris extends BaseNabiz{
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@Test
	public void standart_giris(String gecerli_mail,String gecerli_sifre) throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		gundem.profilim.click();
		profil.girisYap.click();
	    
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.eposta_girme_alani.click();
		giris.eposta_girme_alani.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.sifre_girme_alani.click();
		giris.sifre_girme_alani.sendKeys(gecerli_sifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.normal_Giris.click();
		giris.devam_et.click();
		
		String kullanicinin_maili = (String)profil.kullanicinin_maili.getText();
		
		assertEquals(gecerli_mail, kullanicinin_maili);
		
		Thread.sleep(2000);
		
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
