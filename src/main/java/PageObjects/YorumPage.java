package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class YorumPage {
	
	public YorumPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/bottom_comment_btn")
	public WebElement yorum_butonu;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Yorumunuz…']")
	public WebElement yorum_yaz;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/send_btn")
	public WebElement yorum_gonder;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/comment_article_title")
	public WebElement yorum_haber_basligi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/comment_body")
	public List<WebElement> yorumun_govdesi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/like_btn")
	public List<WebElement> yorum_begen_butonu;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/likes_count")
	public List<WebElement> yorum_begeni_sayisi;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/delete_btn")
	public List<WebElement> yorum_silme_butonu;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bu yorumu silmek istediğinizden emin misiniz?']")
	public WebElement eminmisiniz;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement evet;
	
	@AndroidFindBy(id = "android:id/button2")
	public WebElement hayir;
	
	@AndroidFindBy(id = "com.waveline.nabiz:id/comment_view_main_container")
	public List<WebElement> tum_yorumlar;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='DEVAM ET']")
	public WebElement yorum_devam_et;

}
