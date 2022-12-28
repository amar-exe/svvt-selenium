package ba.edu.ibu.lab6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
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
        webDriver.navigate().to(baseUrl + "/covid");
        Thread.sleep(5000);
        String title = webDriver.getTitle();
        assertEquals("Covid 19 measures and information | IBU", title);
        webDriver.navigate().back();
        Thread.sleep(3000);
        title = webDriver.getTitle();
        assertEquals("International Burch University | IBU", title);
    }
}
