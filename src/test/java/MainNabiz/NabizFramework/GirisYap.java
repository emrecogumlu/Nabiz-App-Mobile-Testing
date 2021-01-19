package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import PageObjects.TwitterİzinPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYap extends BaseNabiz{
	
//	GundemPage gundem = new GundemPage(driver);
//	ProfilimPage profil = new ProfilimPage(driver);
//	GirisYapPage giris = new GirisYapPage(driver);
//	Utilities utilities = new Utilities(driver);
//	TwitterİzinPage twitter_izin = new TwitterİzinPage(driver);
	@Test(priority = 1)
	public void facebookla_gir() throws InterruptedException, IOException  
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		gundem.profilim.click();
		
		profil.girisYap.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.facebook_Giris.click();
		giris.devam_et.click();
		
		utilities.scrollIntoText("Oturumu kapat");
		profil.oturumu_Kapat1.get(1).click();
		profil.oturumu_Kapat2.click();	
	}
	
	@Test(priority = 2)
	public void twitterla_gir() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		TwitterİzinPage twitter_izin = new TwitterİzinPage(driver);
			
		gundem.profilim.click();
		profil.girisYap.click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.twitter_Giris.click();
		
		utilities.scrollIntoText("UYGULAMAYA İZİN VER");
		Thread.sleep(10000);
		twitter_izin.twitter_izinver.click();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='DEVAM ET']")));
		giris.devam_et.click();
		
		
		utilities.scrollIntoText("Oturumu kapat");
		profil.oturumu_Kapat1.get(1).click();
		profil.oturumu_Kapat2.click();
		
		
	}
	
	@Test(priority = 3)
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
	
	@Test(priority = 4)
	public void no_input_Giris() throws InterruptedException, IOException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		
		
		gundem.profilim.click();
		profil.girisYap.click();
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.normal_Giris.click();
		
		boolean the_visibity;
		
		if(giris.epostani_gir.isDisplayed() & giris.sifreni_gir.isDisplayed()) 
		{
			the_visibity = true;
		}
		else 
		{
			the_visibity = false;
		}
		
		assertEquals(true, the_visibity);
		
	}
	
	@Parameters({"gecerli_mail"})
	@Test(priority = 5)
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
	
	
	@Test(priority = 6)
	public void yanlis_mail() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		String uretilenMail= utilities.randomMail();
		String uretilenSifre= utilities.randomPassword(6);
		
		
		gundem.profilim.click();
		profil.girisYap.click();
	    
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.eposta_girme_alani.click();
		giris.eposta_girme_alani.sendKeys(uretilenMail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.sifre_girme_alani.click();
		giris.sifre_girme_alani.sendKeys(uretilenSifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.normal_Giris.click();
		
		String actualMessage = "Geçerli bir email girin";
		String toastMessage = giris.uyari_mesaji.getAttribute("name");
		assertEquals(actualMessage, toastMessage);
	}
	
	@Test(priority = 7)
	public void dusuk_karakterli_sifre() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		String uretilenMail= utilities.randomMail();
		String uretilenSifre= utilities.randomPassword(5);
		
		
		gundem.profilim.click();
		profil.girisYap.click();
	    
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.eposta_girme_alani.click();
		giris.eposta_girme_alani.sendKeys(uretilenMail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.sifre_girme_alani.click();
		giris.sifre_girme_alani.sendKeys(uretilenSifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		giris.normal_Giris.click();
		
		boolean the_visibity;
		
		if(giris.alti_karakter.isDisplayed()) 
		{
			the_visibity = true;
		}
		else 
		{
			the_visibity = false;
		}
		
		assertEquals(true, the_visibity);
	}
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@Test(priority = 8)
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
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	
	
	
}
