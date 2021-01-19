package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilimPage {
	
	public ProfilimPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.waveline.nabiz:id/login_btn")
	public WebElement girisYap;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Oturumu kapat']")
	public List<WebElement> oturumu_Kapat1;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OTURUMU KAPAT']")
	public WebElement oturumu_Kapat2;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/settings_user_email")
	public WebElement kullanicinin_maili;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Kaynakları Düzenle']")
	public WebElement kaynaklari_duzenle;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/item_switch")
	public List<WebElement> ac_kapa;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Favoriler']")
	public WebElement favoriler;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Başlıkların Yazı Tipi Boyutu']")
	public WebElement baslik_boyut;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NabizApp']")
	public WebElement facebook;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='@NabizApp']")
	public List<WebElement> twit_insta;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nabız Uygulaması - Nabiz App - Ana Sayfa']")
	public WebElement facebook_uygulama;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='@nabizapp']")
	public WebElement twitter_uygulama;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='nabizapp']")
	public WebElement instagram_uygulama;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Kaynak Önerin']")
	public WebElement kaynak_onerin;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/source_edit_field")
	public WebElement onerecegini_yaz;
	
	
	
}
