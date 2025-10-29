package testsLesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentLogosTest extends BaseTest {
    @Test
    public void checkPaymentLogos(){
        WebElement payPartnersBlock = driver.findElement(By.className("pay__partners"));
        List<WebElement> logoImages = payPartnersBlock.findElements(By.tagName("img"));
        assertFalse(logoImages.isEmpty(), "Логотипы платежных систем не найдены.");
        assertEquals(5,logoImages.size(), "Неверное количество логотипов.");
        System.out.println("Найдено логотипов: " + logoImages.size());
    }
}
