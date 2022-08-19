package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.ExecuteOnTarget;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class SeleniumTest {
    @BeforeEach
    void openDriver() {
        Configuration.browser = "safari";
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @ExecuteOnTarget("chrome")
    void isChrome() {
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
//    @ExecuteOnTarget("safari")
    void isSafari() {
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
//    @ExecuteOnTarget("firefox")
    void isFirefox() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("edge")
    void isEdge() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("opera")
    void isOpera() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("ie")
    void isIE() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }
}
