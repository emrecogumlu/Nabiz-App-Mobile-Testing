package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GundemPage {
	
	public GundemPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Profilim']")
	public WebElement profilim;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gündem']")
	public WebElement gundemim;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nabız Dergileri']")
	public WebElement nabiz_dergileri;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_cell_layout")
	public List<WebElement> gundem_haberler;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/search_btn")
	public WebElement arama_butonu;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/search_edit_field")
	public WebElement arayacagini_yaz;
	

}
