package utilities;

import static utilities.PropertiesLoader.getProperty;

public class GetData {

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

}
