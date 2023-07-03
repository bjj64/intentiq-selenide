package utils;

import com.codeborne.selenide.Configuration;

public class BrowserConfiguration {
    public static void configure() {
System.setProperty("selenide.browser", "firefox");
// System.setProperty("selenide.browserBinary", "/usr/local/bin/geckodriver");
System.setProperty("privacy.thirdparty.isolate", "true");
System.setProperty("privacy.thirdparty.isolate.restrict_opener_access", "true");
System.setProperty("privacy.resistFingerprinting", "true");
System.setProperty("privacy.trackingprotection.enabled", "true");
System.setProperty("selenide.browserSize", "1024x768");
System.setProperty("selenide.browserCapabilities", "network.cookie.cookieBehavior=4");
System.setProperty("selenide.browserUserAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1");
        // Set other configurations if needed
        Configuration.timeout = 10000;
        // ...
    }
}
