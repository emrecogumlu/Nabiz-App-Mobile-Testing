package MainNabiz.NabizFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import PageObjects.TwitterİzinPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapTwitter extends BaseNabiz{
	
	@Test
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
		//Thread.sleep(10000);
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='UYGULAMAYA İZİN VER']")));
		twitter_izin.twitter_izinver.click();
		//Thread.sleep(10000);
//		WebDriverWait wait2 = new WebDriverWait(driver, 10);
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='DEVAM ET']")));
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
