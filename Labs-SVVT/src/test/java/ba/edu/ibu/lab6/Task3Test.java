package ba.edu.ibu.lab6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Amar\\Desktop\\Folders\\School\\V Semester\\System Verification, " +
                        "Validaiton and Testing\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "http://www.uitestingplayground.com/sampleapp";
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

    @Test
    void testTitle() throws InterruptedException {
        webDriver.get(baseUrl);
        WebElement username = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        assertEquals("input", username.getTagName());
        assertEquals("input", password.getTagName());

        username.clear();
        password.clear();

        username.sendKeys("test");
        password.sendKeys("pwd");

        WebElement loginBtn = webDriver.findElement(By.id("login"));
        assertEquals("button", loginBtn.getTagName());

        loginBtn.click();

        WebElement loginStatus = webDriver.findElement(By.id("loginstatus"));
        assertTrue(loginStatus.getText().contains("test"));
    }
}
