# Nabiz-App-Mobile-Testing

Hello guys! In this repository, I am sharing with you a project called "Nabiz Application Mobile Testing" which provides to run multiple test cases for an Native App called "Nabiz" by using Appium, TestNg, Maven etc.

If we talk about our application that we tested before starting, this news application, named "Nabiz", is an application that basically aims to show users new news according to the category and news sources they choose.

You can run this project through your IDE, maven or Jenkins as well. But before running it make sure that you set the some requirements.

Requirements:

-As I said above, this project requires Appium, TestNg, Appium etc. Make sure you have them these tools in your machine and set their dependency in the "pom.xml" file!

-This project can be executed through both Real Device and Emulator. To set that, first, go to "global.properties" file and write your device name. If you want to run this project through emulator go to "startEmulator.bat" file and edit it according to your emulator knowledge. Also in the "BaseNabiz.java" file, you need to change your emulator name in the "startEmulator" part.

-In this project, some applications like Facebook, Twitter and Instagram are required. Make sure you have them in your device. You also need to have an account on those applications as well!

-Before executing the project please, create an account on Nabiz application and give the necessary permissions for Facebook, Twitter and Instagram. Also before the first execution make sure you logged out in the application.

-There are two 2 profiles in this project (Regression and Smoke). And their xml files are "testing.xml" and "testing2.xml". In those xml files make sure that you set your account mail and account password as parameters.





TEST CASES:

There are 21 test cases in this project. Each of them controls necessary requirements. To talk about these:

-GirisYapFacebook : Checks for Facebook login.
-GirisYapTwitter : Checks for Twitter login.
-GirisYapGoogle : Checks for Google login.
-GirisYapNoInput : Checks whether the error message appears when the user does not enter input in the login page.
-GirisYapYanlisSifre : Checks if the error message appears when the user tries to login with valid mail and invalid password.
-GirisYapYanlisMail : Checks if the error message appears when the user tries to login with invalid mail.
-GirisYapDusukKarakterliSifre : Checks if the error message appears when the user tries to login with a password with less than 6 characters.
-GirisYapStandartGiris : When the user tries to login with valid e-mail and valid password, it checks whether the user has successfully logged in.
-ProfilKaynakEkle : When the user adds a new news source, it checks whether it is included in the user's preferences.
-ProfilKaynakCikar : When the user removes a existing news source, it checks whether it is discarded in the user's preferences.
-ProfilGeceModu : When the user wants to run the application in night mode, it checks its feasibility.
-FavoriHaberEkle : When the user likes a new on the home screen, it checks whether it has been added to the favorites section on the user's page.
-FavoriHaberCikar : When the user unlikes a new that the user has liked before, it checks whether it has been removed from the the favorites section on the user's page.
-YorumEkleSil : It checks whether the user can comment on an existing article, whether the user can delete a comment that he did before and whether the user can like an existing comment.
-BaslıkBoyutuAyarla : Checks if the headline size can be changed.
-FacebookSayfamiz : Checks whether the application's Facebook page can be visited.
-TwitterSayfamiz : Checks whether the application's Twitter page can be visited.
-InstagramSayfamiz : Checks whether the application's Instagram page can be visited.
-AramaYapma : When the user performs a search in the search section, it checks whether the results are relevant to the search.
-NabizDergileriKontrol : When the user selects a category from the magazines section, it checks whether the news sources they come across really belong to that category.
-KaynakOnerme : Kullanıcının uygulama için yeni bir kaynak önerip öneremeyeceğini kontrol eder.



