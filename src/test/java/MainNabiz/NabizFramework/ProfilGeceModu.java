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

public class ProfilGeceModu extends BaseNabiz{
	
	@Test
	public void gece_modu() 
	{
		GundemPage gundem = new GundemPage(driver);
		ProfilimPage profil = new ProfilimPage(driver);
		gundem.profilim.click();
		
		String ac_kapat1String = profil.ac_kapa.get(0).getText();
		
		profil.ac_kapa.get(0).click();
		
		String ac_kapat2String = profil.ac_kapa.get(0).getText();
		
		assertEquals(ac_kapat1String.equals(ac_kapat2String), false);
		
		profil.ac_kapa.get(0).click();
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
