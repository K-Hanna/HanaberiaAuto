package utilities;

import static utilities.PropertiesLoader.getProperty;

public class PreconditionSetter {

    public static void setProperties(){
        setBrowser();
        setBaseUrl();
    }

    public static void setBaseUrl(){
        TestData.setBaseUrl(getProperty("base.url"));
    }

    public static void setBrowser(){
        TestData.setBrowser(getProperty("browser"));
    }
}
