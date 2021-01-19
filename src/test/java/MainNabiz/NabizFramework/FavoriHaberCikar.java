package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.GundemPage;
import PageObjects.HaberSayfasıPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FavoriHaberCikar extends BaseNabiz{
	
	@Test
	public void favorilerden_cikar() throws InterruptedException 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		HaberSayfasıPage haber_sayfasi = new HaberSayfasıPage(driver);
		
		gundem.profilim.click();
		profil.favoriler.click();
		Thread.sleep(1500);
		haber_sayfasi.favorideki_haberler.get(0).click();
		String favori_haber_basligim=haber_sayfasi.haber_basligi.getText();
		assertEquals(haber_sayfasi.favorited_button.isDisplayed(), true);
		haber_sayfasi.favorited_button.click();
		String actualMessagee = "Haber favorilerinizden çıkartıldı";
		String toastMessagee = haber_sayfasi.uyari_mesaji2.getAttribute("name");
		assertEquals(actualMessagee, toastMessagee);
		assertEquals(haber_sayfasi.favorite_button.isDisplayed(), true);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		String en_son_favori_haber_basligim = haber_sayfasi.favorideki_haberler.get(0).getText();
		
		assertNotEquals(en_son_favori_haber_basligim, favori_haber_basligim);
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
