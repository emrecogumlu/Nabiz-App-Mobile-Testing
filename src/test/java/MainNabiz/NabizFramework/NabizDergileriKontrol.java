package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GundemPage;
import PageObjects.HaberSayfasıPage;
import PageObjects.KaynaklariDuzenlePage;
import PageObjects.NabizDergileriPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NabizDergileriKontrol extends BaseNabiz{
	
	@Test
	public void nabiz_dergileri_kontrol_et() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		NabizDergileriPage nabizDergileri = new NabizDergileriPage(driver);
		HaberSayfasıPage haber_sayfasi = new HaberSayfasıPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		KaynaklariDuzenlePage kaynak = new KaynaklariDuzenlePage(driver);
		
		gundem.nabiz_dergileri.click();
		nabizDergileri.nabizlar.get(5).click();
		Thread.sleep(1500);
		String myString1=haber_sayfasi.kaynak_adi.getText();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		gundem.profilim.click();
		profil.kaynaklari_duzenle.click();
		kaynak.kategoriler_ekonomi.click();
		
		int counter=kaynak.tum_kaynaklar.size();
		boolean chck=false;
		for(int i=0; i<counter; i++) 
		{
			if(kaynak.tum_kaynaklar.get(i).getText().equals(myString1)) 
			{
				chck=true;
				break;
			}
		}
		
		assertEquals(chck, true);
		
		
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
