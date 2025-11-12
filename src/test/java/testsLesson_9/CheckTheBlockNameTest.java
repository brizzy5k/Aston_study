package testsLesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static org.junit.jupiter.api.Assertions.*;

public class CheckTheBlockNameTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(CheckTheBlockNameTest.class);

    @Test
    public void checkTheBlockName() {
        WebElement blockTitle = driver.findElement(
                By.xpath("//div[contains(@class,'pay__wrapper')]//h2[contains(text(), 'Онлайн пополнение ')]")
        );
        String actualTitle = blockTitle.getText().trim();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        logger.info("Название блока соответствует ожидаемому");
    }
}
