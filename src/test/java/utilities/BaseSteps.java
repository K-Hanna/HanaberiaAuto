package utilities;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static utilities.PropertiesLoader.getProperty;

public class BaseSteps {

    public static String baseUrl(){
        return getProperty("base.url");
    }

    public static String userLogin(){
        return getProperty("user.login");
    }

    public static String userPassword(){
        return getProperty("user.password");
    }

    public static String adminLogin(){
        return getProperty("admin.login");
    }

    public static String adminPassword(){
        return getProperty("admin.password");
    }

    public static String loginAs(){
        return getProperty("login.as");
    }

    public static String newLogin(){
        return getProperty("new.login");
    }

    public static String newContactForm1(){
        return getProperty("new.contactForm1");
    }

    public static String newContact1(){
        return getProperty("new.contact1");
    }

    public static String newContactForm2(){
        return getProperty("new.contactForm2");
    }

    public static String newContact2(){
        return getProperty("new.contact2");
    }

    public static String newPassword(){
        return getProperty("new.password");
    }

    public void logInAsUser(WebDriver driver){
        new LoginPage(driver)
            .fillUserName(userLogin())
            .fillPassword(userPassword())
            .submit();
    }

    public void logInAsAdmin(WebDriver driver){
        new LoginPage(driver)
                .fillUserName(adminLogin())
                .fillPassword(adminPassword())
                .submit();
    }

    public void logInAs(WebDriver driver){

        String login = "";
        String password = "";

        switch (loginAs()) {
            case "user" -> {
                login = userLogin();
                password = userPassword();
            }
            case "admin" -> {
                login = adminLogin();
                password = adminPassword();
            }
            default -> System.out.println("Wrong login");
        }

        new LoginPage(driver)
                .fillUserName(login)
                .fillPassword(password)
                .submit();

    }
}
