package testsLesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceDetailsLinkTest extends BaseTest {
    @Test
    public void checkServiceDetailsLinkClick() {
        WebElement detailsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));
        assertTrue(detailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        assertEquals("a", detailsLink.getTagName(), "Элемент не является ссылкой");

        String href = detailsLink.getAttribute("href");
        assertNotNull(href, "У ссылки отсутствует href атрибут");
        assertFalse(href.isEmpty(), "У ссылки пустой href атрибут");

        System.out.println("Ссылка '" + detailsLink.getText() + "' найдена.\nURL ссылки: " + href);

        String originalUrl = driver.getCurrentUrl();
        detailsLink.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));

        String newUrl = driver.getCurrentUrl();
        assertNotEquals(originalUrl, newUrl, "Переход по ссылке не произошел");

        System.out.println("Переход по ссылке произошел успешено");
    }
}
