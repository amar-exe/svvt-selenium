package ba.edu.ibu.lab10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab10 {
        private static WebDriver webDriver;
        private static String baseUrl;

        @BeforeAll
        static void setUp() {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Amar\\Desktop\\Folders\\School\\V Semester\\System Verification, " +
                            "Validaiton and Testing\\chromedriver.exe");
            webDriver = new ChromeDriver();
            baseUrl = "https://demoqa.com/checkbox";
        }

        @AfterAll
        static void tearDown() {
            webDriver.quit();
        }

        @Test
        void task1() throws InterruptedException {
            webDriver.get(baseUrl);
            webDriver.manage().window().maximize();

            webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
            webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")).click();

            WebElement workspace = webDriver.findElement(By.id("tree-node-workspace"));
            WebElement office = webDriver.findElement(By.id("tree-node-office"));

            assertTrue(workspace.isSelected());
            assertTrue(office.isSelected());
        }

        @Test
        void task3() {
            webDriver.get("https://phptravels.net/tours");
            webDriver.manage().window().maximize();

            webDriver.findElement(By.xpath("//*[@id=\"cookie_stop\"]")).click();

            webDriver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div/div/div[2]/div[1]/div/div[1]/a[1]/div/div")).click();

            Select adults = new Select(webDriver.findElement(By.xpath("//*[@id=\"adults\"]")));
            adults.selectByValue("2");

            Select children = new Select(webDriver.findElement(By.xpath("//*[@id=\"childs\"]")));
            children.selectByValue("1");

            Select infant = new Select(webDriver.findElement(By.xpath("//*[@id=\"infants\"]")));
            infant.selectByValue("1");

            assertEquals("171",
                    webDriver.findElement(By.xpath("//*[@id=\"fadein\"]/section[2]/div[2]/div/div/div[2]/div/div/div/div/div/p/span/span"))
                            .getText()
                    );


        }


}
