package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HaberSayfasıPage {
	
	public HaberSayfasıPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/favorite_btn")
	public WebElement favorite_button;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/favorited_btn")
	public WebElement favorited_button;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_details_title")
	public WebElement haber_basligi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_details_pub_date")
	public WebElement haber_yayin_tarihi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_details_article_time")
	public WebElement haber_ne_kadar_once;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_details_body")
	public WebElement haber_detayi;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement uyari_mesaji2;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/article_cell_layout")
	public List<WebElement> favorideki_haberler;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/source_name")
	public WebElement kaynak_adi;

}
