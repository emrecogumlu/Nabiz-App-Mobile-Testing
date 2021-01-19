package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.KaynaklariDuzenlePage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ProfilKaynakEkle extends BaseNabiz{
	
	
	@Test
	public void kaynaklari_Duzenle() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		Utilities utilities = new Utilities(driver);
		KaynaklariDuzenlePage kaynaklar = new KaynaklariDuzenlePage(driver);
		
		gundem.profilim.click();
		profil.kaynaklari_duzenle.click();
		kaynaklar.kategoriler_gazeteler.click();
		
		String mySourceNameString = kaynaklar.tum_kaynaklar.get(1).getText();
		
		kaynaklar.kaynak_ekle_cikar.get(1).click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		utilities.scrollIntoText("Kaynaklarım");
		kaynaklar.kaynaklarim.click();
	
		
		int counter = kaynaklar.tum_kaynaklar.size();
		String [] butun_kaynak_adlari = new String[counter];
		
		for(int i=0 ; i<=counter-1 ; i++) 
		{
			butun_kaynak_adlari[i]=kaynaklar.tum_kaynaklar.get(i).getText();
		}
		
		
		
		boolean check = false;
		for(int m=0 ; m<=counter-1 ; m++) 
		{
			if(butun_kaynak_adlari[m].equals(mySourceNameString)) 
			{
				check=true;
				break;
			}
			else 
			{
				check=false;
			}
		}
			
		assertEquals(check, true);
		
		
		
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
	public void a_killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@BeforeTest
	public void b_log_in(String gecerli_mail,String gecerli_sifre) throws InterruptedException, IOException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("NabizApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		GirisYapPage giris = new GirisYapPage(driver);
		
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
		
		service.stop();
	
	}
	
	@AfterTest
	public void log_out() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("NabizApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		Utilities utilities = new Utilities(driver);
		
		gundem.profilim.click();
		utilities.scrollIntoText("Oturumu kapat");
		profil.oturumu_Kapat1.get(1).click();
		profil.oturumu_Kapat2.click();
		
		service.stop();
	}
	
	
}
