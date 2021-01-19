package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GundemPage;
import PageObjects.KaynaklariDuzenlePage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ProfilKaynakCikar extends BaseNabiz{
	
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
		
		String myySourceNameString = kaynaklar.tum_kaynaklar.get(1).getText();
		kaynaklar.kaynak_ekle_cikar.get(1).click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		utilities.scrollIntoText("Kaynaklarım");
		kaynaklar.kaynaklarim.click();
		
		int counterr = kaynaklar.tum_kaynaklar.size();
		String [] butunn_kaynak_adlari = new String[counterr];
		
		for(int j=0 ; j<=counterr-1 ; j++) 
		{
			butunn_kaynak_adlari[j]=kaynaklar.tum_kaynaklar.get(j).getText();
		}
		
		
		
		boolean checkk= false;
		for(int k=0 ; k<=counterr-1 ; k++) 
		{
			if(butunn_kaynak_adlari[k].equals(myySourceNameString)) 
			{
				checkk=true;
				break;
			}
		}
			
		assertEquals(checkk, false);
		
		
		
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
