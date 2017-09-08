package FichaTecnica;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import FichaTecnica.Automacao.Objects.Login.LoginObjects;
import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import org.apache.commons.lang3.SystemUtils;

import com.google.common.collect.PeekingIterator;

import FichaTecnica.Automacao.Actions.LoginAction;
import FichaTecnica.Automacao.Resources.CapsSelenium;

/**
 * @author: Thiago Carreira A. Nascimento
 * Classe de teste
 */
public class SuiteFluxoConsulta {

	private WebDriver driver = null;
    public String systemDriver = null;
    private String usuario = "admin";
    private String senha = "admin";
	private CapsSelenium configSelenium;
	private Logger log = null;
	private LoginObjects loginObjects;
	private String fichaTecnicaURL = "http://localhost:8888/ftp/"; //passar como parametro de execucao
	private String welcome;

    /**
     * Metodo que configura os capabilities para o selenium, rodando em GRID via Docker - sem teste ainda :(
     * @param driver
     * @param url
     * @throws MalformedURIException
     * @throws MalformedURLException
     */
//	@Parameters({"DRIVER", "SELENIUM_URL"})
//	@BeforeTest
//	public void setUpCaps(String driver, String url) throws MalformedURIException, MalformedURLException {
//		if(driver.equalsIgnoreCase("chrome")) {
//            this.driver = new ChromeDriver();
//            configSelenium.setUp(driver);
//			this.driver = new RemoteWebDriver(new URL (url),configSelenium.getCaps());
//			this.driver.get(fichaTecnica);
//		} else if(driver.equalsIgnoreCase("firefox")) {
//		    this.driver = new FirefoxDriver();
//            configSelenium.setUp(driver);
//			this.driver = new RemoteWebDriver(new URL(url), configSelenium.getCaps());
//			this.driver.get(fichaTecnica);
//		} else {
//			System.out.println("nao identificado");
//		}
//	}
    /**
     * Método que define as configurações de execução do Selenium. Note que o método não identifica o Mac OS Sierra.
     * Caso o TestNG apresente um erro dizendo que "não é possível executar o chromedriver", verifique se o arquivo tem permissão de execução
     * em seu computador (mude com: 'chmod +x chromedriver') - o mesmo problema pode ocorrer em GNU-Linux.
     */
    @BeforeMethod
    public void beforeMethod(){
        try{
            if(SystemUtils.IS_OS_WINDOWS_7 || SystemUtils.IS_OS_WINDOWS_8 || SystemUtils.IS_OS_WINDOWS_10){
                systemDriver = "chromedriver.exe";
            } else if(SystemUtils.IS_OS_LINUX){
                systemDriver = "chromedriverLinux";
            } else if(SystemUtils.IS_OS_MAC_OSX_EL_CAPITAN){ //nao identifica o Sierra
                systemDriver= "chromedriver";
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("Sistema não identificado, tentando driver para Windows...");
            systemDriver = "chromedriver"; //mudei só pra tester no meu computador :)
        }

        System.setProperty("webdriver.chrome.driver", "src/main/java/utils/"+systemDriver);
        ChromeOptions op = new ChromeOptions();
        op.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        this.driver = new ChromeDriver(op); //usar RemoteDriver p/ apontar p/ container
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get(fichaTecnicaURL);
    }

    @AfterMethod
    public void afterMethod(){
        this.driver.quit();
    }



//	@Parameters({"DRIVER"}) //
	@Test
	public void testLogin() {
		LoginAction login = new LoginAction(this.driver, this.usuario, this.senha);
		login.logar();
		loginObjects = new LoginObjects(driver);
		this.welcome = loginObjects.welcome.getText();
		Assert.assertEquals(welcome, welcome.contains("Bem"));
	}
	
//	@AfterTest
//	public void closeUp() {
//		this.driver.close();
//	}

}
