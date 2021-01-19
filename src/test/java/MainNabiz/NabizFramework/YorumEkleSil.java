package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GundemPage;
import PageObjects.HaberSayfasıPage;
import PageObjects.ProfilimPage;
import PageObjects.YorumPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class YorumEkleSil extends BaseNabiz{
	
	@Test
	public void yorum_ekle_sil() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profilim = new ProfilimPage(driver);
		HaberSayfasıPage haber_sayfasi = new HaberSayfasıPage(driver);
		YorumPage yorum = new YorumPage(driver);
		
		gundem.profilim.click();
		profilim.favoriler.click();
		haber_sayfasi.favorideki_haberler.get(0).click();
		String favori_haber_basligim = haber_sayfasi.haber_basligi.getText();
		String yorumum = "Haber icin tesekkurler!";
		yorum.yorum_butonu.click();
		yorum.yorum_gonder.click();
		assertEquals(yorum.yorum_devam_et.isDisplayed(), true);
		yorum.yorum_devam_et.click();
		yorum.yorum_yaz.click();
		yorum.yorum_yaz.sendKeys(yorumum);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		yorum.yorum_gonder.click();
		
		
		int counter = yorum.tum_yorumlar.size();
		
		String[] butun_yorumlar = new String[counter];
		
		for(int i=0 ; i<counter ; i++) 
		{
			butun_yorumlar[i]=yorum.tum_yorumlar.get(i).getText();
		}
		
		String yorumdaki_haber_basligi = yorum.yorum_haber_basligi.getText();
		
		assertEquals(yorumdaki_haber_basligi, favori_haber_basligim);
		
		String yorumun_kendisi = yorum.yorumun_govdesi.get(0).getText();
		
		Thread.sleep(3000);
		
		assertEquals(yorumun_kendisi, yorumum);
		
		yorum.yorum_begen_butonu.get(0).click();
		
		int yorum_begeni_sayisii = Integer.parseInt(yorum.yorum_begeni_sayisi.get(0).getText());
		
		assertEquals(yorum_begeni_sayisii, 1);
		
		yorum.yorum_silme_butonu.get(0).click();
		
		assertEquals(yorum.eminmisiniz.isDisplayed(), true);
		
		yorum.evet.click();
		
		butun_yorumlar = ArrayUtils.remove(butun_yorumlar,0);
		
		if(butun_yorumlar.length==0) 
		{
			assertEquals(true, true);
		}
		else 
		{
			for(int j=0 ; j<counter-1 ; j++) 
			{
				if(butun_yorumlar[j].equals(yorumum)) 
				{
					assertEquals(false, true);
				}
				else 
				{
					assertEquals(true, true);
				}
			}
		}
		
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
