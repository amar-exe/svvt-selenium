package ba.edu.ibu.lab6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Amar\\Desktop\\Folders\\School\\V Semester\\System Verification, " +
                        "Validaiton and Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "https://it.ibu.edu.ba/";
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    void testTitle() throws InterruptedException {
        webDriver.get(baseUrl);
        String title = webDriver.getTitle();
        String source = webDriver.getPageSource();
        assertEquals("Department of Information Technology | IBU", title);
        assertTrue(source.contains("_next"));
    }
}
