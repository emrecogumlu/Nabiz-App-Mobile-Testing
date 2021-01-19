package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
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

public class FavoriHaberEkle extends BaseNabiz{
	
	@Test
	public void favorilere_ekle() throws InterruptedException
	{
		GundemPage gundem = new GundemPage(driver);
		HaberSayfasıPage habersayfasi = new HaberSayfasıPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		
		
		Thread.sleep(5000);
		gundem.gundemim.click();
		
		gundem.gundem_haberler.get(0).click();
		String haber_basligim=habersayfasi.haber_basligi.getText();
		assertEquals(habersayfasi.favorite_button.isDisplayed(), true);
		habersayfasi.favorite_button.click();
		String actualMessagee = "Haber favorilerinize eklendi";
		String toastMessagee = habersayfasi.uyari_mesaji2.getAttribute("name");
		assertEquals(actualMessagee, toastMessagee);
		assertEquals(habersayfasi.favorited_button.isDisplayed(), true);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		gundem.profilim.click();
		profil.favoriler.click();
		//utilities.scrollIntoText(habersayfasi.favorideki_haberler.get(0).getText());
		habersayfasi.favorideki_haberler.get(0).click();
		String favori_haber_basligim=habersayfasi.haber_basligi.getText();
		
		assertEquals(haber_basligim, favori_haber_basligim);
		
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
