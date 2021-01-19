package MainNabiz.NabizFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.GirisYapPage;
import PageObjects.GundemPage;
import PageObjects.ProfilimPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GirisYapNoInput extends BaseNabiz{
	
	@Test
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
