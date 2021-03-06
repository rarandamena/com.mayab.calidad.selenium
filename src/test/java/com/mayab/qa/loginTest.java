package com.mayab.qa;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class loginTest {



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\Desktop\\semestre2019a\\calidad\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    public loginTest() {
    }

    private static final String URL = "https://www.facebook.com";
    private static WebDriver driver;

    @Test
    public void JavaLoginSuccess() throws InterruptedException {
        driver.get(URL);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        username.sendKeys("Selenium");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        pass.sendKeys("cartas10");
        pass.submit();
        Thread.sleep(3000);
        try {
            WebElement passOK = driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span"));
            String loginSuccessful = passOK.getText();
            assertEquals(loginSuccessful, "Selenium");
        }catch (Exception e){
            System.out.println("hubo un problema al iniciar sesión");
        }
    }
    @Test
    public void JavaLoginFailed() throws InterruptedException {
        driver.get(URL);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        username.sendKeys("9981056448");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        pass.sendKeys("kerberos1987#");
        pass.submit();

        Thread.sleep(3000);
        WebElement errorPass = driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div"));
        String loginFail =errorPass.getText();
        Assert.assertEquals(loginFail, "La contraseña que ingresaste es incorrecta. ¿Olvidaste tu contraseña?" );

    }
    //
}