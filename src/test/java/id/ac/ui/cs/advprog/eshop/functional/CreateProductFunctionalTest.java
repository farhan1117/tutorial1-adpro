package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createProduct(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        // Find the "Product Name" input field by name
        WebElement productNameInput = driver.findElement(By.name("productName"));
        productNameInput.sendKeys("Sampo Cap Bambang");

        // Find the "Product Quantity" input field by name
        WebElement productQuantityInput = driver.findElement(By.name("productQuantity"));
        productQuantityInput.sendKeys("100");

        // Submit the form
        productQuantityInput.sendKeys(Keys.ENTER);

        // Verify that the new product is added and displayed in the product list
        assertEquals(baseUrl + "/product/list", driver.getCurrentUrl());
        WebElement productList = driver.findElement(By.tagName("body"));
        assertEquals(true, productList.getText().contains("Sampo Cap Bambang"));

    }
}
