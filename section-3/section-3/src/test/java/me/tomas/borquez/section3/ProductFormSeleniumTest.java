package me.tomas.borquez.section3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

// This is important so we can run the tests meanwhile developing, and it doesn't hit our endpoint :)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductFormSeleniumTest {
    // Standard selenium setup
    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddProductForm() throws InterruptedException {
        driver.get("http://localhost:" + port + "/");

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement priceInput = driver.findElement(By.id("price"));
        WebElement descriptionInput = driver.findElement(By.id("description"));

        // Send the input
        nameInput.sendKeys("Test Product");
        priceInput.sendKeys("19.99");
        descriptionInput.sendKeys("This is a test product description");

        // Submit the product
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newProductRow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Test Product']")));

        // We assert that the product was added to the HTML
        assertTrue(newProductRow.isDisplayed(), "New product should be displayed in the table");
        assertTrue(driver.findElement(By.xpath("//td[text()='$19.99']")).isDisplayed(), "New product price should be displayed");
        assertTrue(driver.findElement(By.xpath("//td[text()='This is a test product description']")).isDisplayed(), "New product description should be displayed");
    }
}
