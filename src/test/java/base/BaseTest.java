package base;

import org.testng.annotations.*;

import com.microsoft.playwright.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        page = browser.newPage();

        System.out.println("Browser launched");
    }

    @AfterMethod
    public void tearDown() {

        browser.close();

        playwright.close();

        System.out.println("Browser closed");
    }
}