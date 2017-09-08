package FichaTecnica.Automacao.Objects.Login;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Thiago Carreira Alves Nascimento
 * Classe dos objetos operados no login do site. 
 * @link: https://github.com/SeleniumHQ/selenium/wiki/Design-Patterns
 * @link: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html
 */

public class LoginObjects {
	
	private WebDriver driver;
	
	public LoginObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	@FindBy(id="login")
	public WebElement userTextField;
	
	@FindBy(id="senha")
	public WebElement passTextField;
	
	@FindBy(className="btn btn-success login pull-center") //terrivel!
	public WebElement entrarButton;
	
	@FindBy(partialLinkText="#modalSenha") //tentar xpath
	public WebElement recoveryLink;
	
	@FindBy(how = How.ID, using ="test") //uma forma diferente de usar o locator
	public WebElement test;

	@FindBy(className = "welcome")
	public WebElement welcome;

}
