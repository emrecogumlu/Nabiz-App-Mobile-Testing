package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FacebookSayfamiz extends BaseNabiz{
	
	@Test
	public void facebook_sayfasi() 
	{
		GundemPage gundem = new GundemPage(driver);
		Utilities utilities = new Utilities(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		
		gundem.profilim.click();
		utilities.scrollIntoText("Nabzı Değerlendirin");
		String myString1=profil.facebook.getText();
		profil.facebook.click();
		
		String myString2=profil.facebook_uygulama.getText();
		myString2=myString2.replaceAll("\\s+", "");
		
		assertEquals(myString2.contains(myString1), true);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
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
