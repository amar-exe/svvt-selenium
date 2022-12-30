package ba.edu.ibu.lab9;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab9 {
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
    void task1() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//*[@id=\"header__section__white\"]/div[2]/div[2]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"header__section__white\"]/div[2]/div[2]/div[2]/div[3]/div/button[1]")).click();
        Thread.sleep(500);

        webDriver.findElement(By.xpath("//*[@id=\"header__section__white\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div/nav/button[1]")).click();
        Thread.sleep(500);

        webDriver.findElement(By.xpath("/html/body/div/header/div[2]/div[2]/div[2]/div[3]/div[3]/div/nav/a[1]")).click();
        Thread.sleep(1000);

        String deanName = webDriver.findElement(By.xpath("//*[@id=\"dean-note\"]/div/div/div[2]/div/div/p")).getText();
        assertTrue(deanName.contains("Jasmin Kevrić"));

    }

    @Test
    void task2() {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        webDriver.manage().window().maximize();

        String sampleAppHeading = webDriver.findElement(By.xpath("/html/body/section/div/h3")).getText();
        assertEquals("Sample App", sampleAppHeading);

        String paragraphText = webDriver.findElement(By.xpath("/html/body/section/div/p")).getText();
        assertEquals(101, paragraphText.length());

        assertEquals("User logged out.",
                webDriver.findElement(By.id("loginstatus")).getText()
                );

        WebElement usernameField = webDriver.findElement(By.name("UserName"));
        WebElement passwordField = webDriver.findElement(By.name("Password"));

        usernameField.sendKeys("wrong");
        passwordField.sendKeys("credentials");

        webDriver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        String errorLabel = webDriver.findElement(By.xpath("//*[@id=\"loginstatus\"]")).getText();
        assertEquals("Invalid username/password", errorLabel);
    }
}
