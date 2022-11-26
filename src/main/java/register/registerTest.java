package register;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class registerTest {
    WebDriver driver;

    @Before
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        //esperar carregar o elemento
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //esperar carregar a página
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }
    @Test
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.preencherNome("Valéria");
        registerPage.preencherSobrenome("Falco");
        registerPage.preencherEndereco("R Joaquim Jacinto");
        registerPage.preencherEmail("teste@teste.com");
        registerPage.preencherPhone("11974883232");
        registerPage.clicarGender();
        registerPage.clicarHobbies();
        registerPage.selecionarSkills("Android");
        registerPage.selecionarCountry();
        registerPage.selecionarAno("1996");
        registerPage.selecionarMes("April");
        registerPage.selecionarDia("4");
    }
//@After
//    public void fecharBrowser(){
//        driver.quit();
//}


//    @Test
//    public void register(){
//
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Valeria");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Falco");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("R Joaquim Jacinto");
//        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("teste@teste.com");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("11974883232");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
//        driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
//        Select select = new Select(driver.findElement(By.id("Skills")));
//        select.selectByVisibleText("Android");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[2]")).click();
//        Select ano = new Select(driver.findElement(By.id("yearbox")));
//        ano.selectByVisibleText("1996");
//        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
//        month.selectByVisibleText("May");
//        Select day = new Select(driver.findElement(By.id("daybox")));
//        day.selectByVisibleText("22");
//
//
////
//    }
    @Test
    public void alertok (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        Assert.assertEquals("TEXTO INVALIDO","I am an alert box!",textoAlert);
        alert.accept();

    }
    @Test
    public void alertcancel(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        String txtAlert = alert.getText();
        Assert.assertEquals("texto inválido","Press a Button !",txtAlert);
        alert.dismiss();

    }
    @Test
    public void alertbox(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Valeria");
        alert.accept();
        String msg = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue("texto alert invalido", msg.contains("Valeria"));
//        Assert.assertEquals("texto inválido","Hello Valeria How are you today",msg);

    }
@Test
    public void frameTeste(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.automationtesting.in/Frames.html");
    //foco no frame
    driver.switchTo().frame(("singleframe"));
    driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("QA Academy");
    //voltar foco para o html
    driver.switchTo().defaultContent();

}
@Test
    public void windowTest(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.automationtesting.in/Windows.html");
    driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
    //capturar todas as janelas
    Object [] janelas = driver.getWindowHandles().toArray();
    //trocar a janela
    driver.switchTo().window(janelas[1].toString());
    String url = driver.getCurrentUrl();
    Assert.assertEquals("https://www.selenium.dev/",url);
     }
}
