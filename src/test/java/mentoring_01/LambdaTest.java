package mentoring_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LambdaTest {

    @Test
    public void TC_01() {

        /*
        Navigate to lambdaTest web https://www.lambdatest.com/selenium-playground/
        click on Input Form Submit
        Once clicked, fill in the input fields, and click submit button
        And finally, verify the success message with assert

         */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.findElement(By.xpath("//a[contains(.,'Input')]")).click();
        WebElement nameField = driver.findElement(By.cssSelector("label~input[id='name']"));
        nameField.sendKeys("Kuba");
        WebElement emailField = driver.findElement(By.cssSelector("label~input[id='inputEmail4']"));
        emailField.sendKeys("test@test.com");

        WebElement passwordField = driver.findElement(By.cssSelector("label~input[id='inputPassword4']"));
        passwordField.sendKeys("12345");

        WebElement companyField = driver.findElement(By.cssSelector("label~input[id='company']"));
        companyField.sendKeys("TestCompany");

        WebElement webSiteField = driver.findElement(By.cssSelector("label~input[id='websitename']"));
        webSiteField.sendKeys("www.google.com");

        WebElement cityField = driver.findElement(By.cssSelector("label~input[id='inputCity']"));
        cityField.sendKeys("Chitown");

        WebElement address1 = driver.findElement(By.cssSelector("label~input[id='inputAddress1']"));
        address1.sendKeys("test address");

        WebElement address2 = driver.findElement(By.cssSelector("label~input[id='inputAddress2']"));
        address2.sendKeys("test address 2");

        WebElement stateField = driver.findElement(By.cssSelector("label~input[id='inputState']"));
        stateField.sendKeys("IL");

        WebElement zipcode = driver.findElement(By.cssSelector("label~input[id='inputZip']"));
        zipcode.sendKeys("60656");

        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(.,'Submit')]"));
        submitBtn.click();

        List<WebElement> allText = driver.findElements(By.xpath("//p"));

        for (int i = 0; i < allText.size(); i++) {

            if (allText.get(i).getText().contains("Thanks")){
                Assert.assertEquals(allText.get(i).getText(), "Thanks for contacting us, we will get back to you shortly.");
                System.out.println(allText.get(i).getText());
                break;
            }


        }





    }
}
