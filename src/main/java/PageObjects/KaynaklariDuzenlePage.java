package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class KaynaklariDuzenlePage {
	
	public KaynaklariDuzenlePage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gazeteler']")
	public WebElement kategoriler_gazeteler;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ekonomi']")
	public WebElement kategoriler_ekonomi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/following_status_img")
	public List<WebElement> kaynak_ekle_cikar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hürriyet']")
	public WebElement kaynak_adi;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Kaynaklarım']")
	public WebElement kaynaklarim;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/sources_cell_source_name")
	public List<WebElement> tum_kaynaklar;

}
