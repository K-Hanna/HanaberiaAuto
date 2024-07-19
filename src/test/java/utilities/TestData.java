package utilities;

public class TestData {
    public static String browser;
    public static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        TestData.baseUrl = baseUrl;
    }

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        TestData.browser = browser;
    }
}
