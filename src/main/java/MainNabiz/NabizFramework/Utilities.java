package MainNabiz.NabizFramework;

import java.util.Random;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {

	
AndroidDriver<AndroidElement> driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver) 
	{
		this.driver = driver;
	}
	
	public void scrollIntoText(String text) 
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));
	}
	
	public String randomMail() 
	{
		int solLimit = 48; // numeral '0'
	    int sagLimit = 122; // letter 'z'
	    int hedefStringUzunlugu = 10;
	    Random random = new Random();

	    String uretilenMail = random.ints(solLimit, sagLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(hedefStringUzunlugu)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    
	    uretilenMail+="@gmail.com";
	    
	    return uretilenMail;
	}
	
	public String randomPassword(int hedefStringUzunlugu) 
	{
		int solLimit = 48; // numeral '0'
	    int sagLimit = 122; // letter 'z'
	    
	    Random random = new Random();

	    String uretilenSifre = random.ints(solLimit, sagLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(hedefStringUzunlugu)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    return uretilenSifre;
	}
	
	
	
	
}
