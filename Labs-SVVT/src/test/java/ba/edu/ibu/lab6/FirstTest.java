package ba.edu.ibu.lab6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Amar\\Desktop\\Folders\\School\\V Semester\\System Verification, " +
                        "Validaiton and Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://ibu.edu.ba/";
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    void testTitle() throws InterruptedException {
        webDriver.get(baseUrl);
        String title = webDriver.getTitle();
        System.out.println("Title: " + title);
        assertEquals("International Burch University | IBU", title);
        Thread.sleep(5000);
    }

    @Test
    void testRedirect() throws InterruptedException {
        webDriver.get("https://it.ibu.edu.ba");
        Thread.sleep(5000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Url: " + currentUrl);
        assertEquals("https://www.ibu.edu.ba/department-of-information-technologies", currentUrl);
    }
}
