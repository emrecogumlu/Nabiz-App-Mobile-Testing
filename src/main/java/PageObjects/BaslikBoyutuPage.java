package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaslikBoyutuPage {
	
	public BaslikBoyutuPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/font_size_small")
	public WebElement small;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/font_size_normal")
	public WebElement normal;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/font_size_large")
	public WebElement large;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/font_size_extra_large")
	public WebElement extra_large;

}
