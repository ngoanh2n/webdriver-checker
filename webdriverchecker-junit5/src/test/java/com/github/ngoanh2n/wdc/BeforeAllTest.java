package com.github.ngoanh2n.wdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class BeforeAllTest extends WDCJUnit5Test {
    @BeforeAll
    static void beforeAll() {
        Assertions.assertThrows(CheckerException.class, WebDriverChecker::getDriver);
        createWebDriver();
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    @BeforeEach
    void beforeEach() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    void test() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }
}
