package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

import static io.github.ngoanh2n.wdc.WDCType.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {

    public static boolean isIE() {
        instances.putIfAbsent(IE, new IEDriverChecker());
        return execute(instances.get(IE));
    }

    public static boolean isEdge() {
        instances.putIfAbsent(EDGE, new EdgeDriverChecker());
        return execute(instances.get(EDGE));
    }

    public static boolean isOpera() {
        instances.putIfAbsent(OPERA, new OperaDriverChecker());
        return execute(instances.get(OPERA));
    }

    public static boolean isChrome() {
        instances.putIfAbsent(CHROME, new ChromeDriverChecker());
        return execute(instances.get(CHROME));
    }

    public static boolean isSafari() {
        instances.putIfAbsent(SAFARI, new SafariDriverChecker());
        return execute(instances.get(SAFARI));
    }

    public static boolean isFirefox() {
        instances.putIfAbsent(FIREFOX, new FirefoxDriverChecker());
        return execute(instances.get(FIREFOX));
    }

    public static boolean isIOS() {
        instances.putIfAbsent(MOBILE_IOS, new IOSDriverChecker());
        return execute(instances.get(MOBILE_IOS));
    }

    public static boolean isAndroid() {
        instances.putIfAbsent(MOBILE_ANDROID, new AndroidDriverChecker());
        return execute(instances.get(MOBILE_ANDROID));
    }

    public static boolean isMobile() {
        return isIOS() || isAndroid();
    }

    public static boolean isMobileNative() {
        instances.putIfAbsent(MOBILE_NATIVE, new NativeDriverChecker());
        return isMobile() && execute(instances.get(MOBILE_NATIVE));
    }

    public static boolean isIE(WebDriver driver) {
        instances.putIfAbsent(IE, new IEDriverChecker());
        return execute(instances.get(IE).useDriver(driver));
    }

    public static boolean isEdge(WebDriver driver) {
        instances.putIfAbsent(EDGE, new EdgeDriverChecker());
        return execute(instances.get(EDGE).useDriver(driver));
    }

    public static boolean isOpera(WebDriver driver) {
        instances.putIfAbsent(OPERA, new OperaDriverChecker());
        return execute(instances.get(OPERA).useDriver(driver));
    }

    public static boolean isChrome(WebDriver driver) {
        instances.putIfAbsent(CHROME, new ChromeDriverChecker());
        return execute(instances.get(CHROME).useDriver(driver));
    }

    public static boolean isSafari(WebDriver driver) {
        instances.putIfAbsent(SAFARI, new SafariDriverChecker());
        return execute(instances.get(SAFARI).useDriver(driver));
    }

    public static boolean isFirefox(WebDriver driver) {
        instances.putIfAbsent(FIREFOX, new FirefoxDriverChecker());
        return execute(instances.get(FIREFOX).useDriver(driver));
    }

    public static boolean isIOS(WebDriver driver) {
        instances.putIfAbsent(MOBILE_IOS, new IOSDriverChecker());
        return execute(instances.get(MOBILE_IOS).useDriver(driver));
    }

    public static boolean isAndroid(WebDriver driver) {
        instances.putIfAbsent(MOBILE_ANDROID, new AndroidDriverChecker());
        return execute(instances.get(MOBILE_ANDROID).useDriver(driver));
    }

    public static boolean isMobile(WebDriver driver) {
        return isIOS(driver) || isAndroid(driver);
    }

    public static boolean isMobileNative(WebDriver driver) {
        instances.putIfAbsent(MOBILE_NATIVE, new NativeDriverChecker());
        return isMobile(driver) && execute(instances.get(MOBILE_NATIVE).useDriver(driver));
    }

    static boolean execute(WebDriverChecker wdc) {
        return wdc.check();
    }

    // ------------

    protected WebDriver driver;
    protected static Map<WDCType, WebDriverChecker> instances = new EnumMap<>(WDCType.class);

    protected abstract boolean check();

    protected WebDriverChecker useDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    protected String getBrowserName() {
        Capabilities caps = getCapabilities();
        return caps.getBrowserName().toLowerCase();
    }

    protected Capabilities getCapabilities() {
        return getRemoteDriver().getCapabilities();
    }

    protected RemoteWebDriver getRemoteDriver() {
        WebDriver driver = getDriver();
        return ((RemoteWebDriver) driver);
    }

    protected WebDriver getDriver() {
        return driver != null ? driver : driverService();
    }

    String getCapability(String name) {
        Object capability = getCapabilities().getCapability(name);
        return String.valueOf(Optional.ofNullable(capability).orElse(""));
    }

    private synchronized WebDriver driverService() {
        ServiceLoader<WebDriverService> service = ServiceLoader.load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next().provide();
        } else {
            throw new IllegalStateException("No implementation of WebDriverService provided");
        }
    }
}
