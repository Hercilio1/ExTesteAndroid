package FichaTecnica.Automacao.Actions;

import org.openqa.selenium.WebDriver;
import FichaTecnica.Automacao.Objects.Login.LoginObjects;

/**
 * @author: Thiago Carreira A. Nascimento
 * Classe que representa o fluxo do teste funcional de Login
 */
public class LoginAction {
	
	private WebDriver driver;
	private LoginObjects loginObj;
	private String usuario, senha;
	
	public LoginAction(WebDriver driver, String usuario, String senha) {
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
		this.loginObj = new LoginObjects(driver);
	}
	
	public void logar() { //tratar excecaoo no testcase
		
			this.loginObj.userTextField.sendKeys(this.usuario);
			this.loginObj.passTextField.sendKeys(this.senha);
			this.loginObj.entrarButton.click();
	}
	
	public void recuperarSenha() {
			// TODO: 27/08/17
	}
	

}
