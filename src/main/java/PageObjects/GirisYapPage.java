package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GirisYapPage {

	public GirisYapPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Facebook ile Giriş Yap']")
	public WebElement facebook_Giris;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Twitter ile Giriş Yap']")
	public WebElement twitter_Giris;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Google ile Giriş Yap']")
	public WebElement google_Giris;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/login_btn")
	public WebElement normal_Giris;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='DEVAM ET']")
	public WebElement devam_et;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='E-posta adresinizi girin']")
	public WebElement epostani_gir;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Şifre girin']")
	public WebElement sifreni_gir;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/login_email_field")
	public WebElement eposta_girme_alani;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/login_password_field")
	public WebElement sifre_girme_alani;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement uyari_mesaji;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Şifreniz en az 6 karakter içermeli']")
	public WebElement alti_karakter;
	
}
