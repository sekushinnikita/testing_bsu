package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.nio.charset.StandardCharsets;

public class OrderPage extends AbstractPage{

    private static final String FIND_BUTTON_XPATH = "//*[@id=\"headerMobShow\"]/div[2]/ui-kit-icon/div/svg";
    private static final String ERROR_MESSAGE_XPATH = "/html/body/rzd-app/div/div/rzd-search-results/div/div/div/rzd-result-mobile/div/div/rzd-search-more/section/div/div[2]";

    @FindBy(xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;
    private JavascriptExecutor js;


    public OrderPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor)driver;
    }

    public OrderPage pressFindButton(){
        findButton.click();
        return this;
    }

    public String getErrorMessage(){
        return new String(
                ((String)js.executeScript("return arguments[0].innerHTML;",
                        driver.findElement(By.xpath(ERROR_MESSAGE_XPATH))))
                .getBytes(StandardCharsets.UTF_8));
    }


}
