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

public class InstagramSayfamiz extends BaseNabiz{
	
	@Test
	public void instagram_sayfasi() 
	{
		GundemPage gundem = new GundemPage(driver);
		Utilities utilities = new Utilities(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		
		gundem.profilim.click();
		utilities.scrollIntoText("Nabzı Değerlendirin");
		String myString1 = profil.twit_insta.get(1).getText();
		myString1=myString1.toLowerCase();
		myString1=myString1.replace("@", "");
		
		profil.twit_insta.get(1).click();
		
		String myString2=profil.instagram_uygulama.getText();
		
		assertEquals(myString1, myString2);
		
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
