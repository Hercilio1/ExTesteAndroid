package action;

import appobjects.LoginObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Classe que representa o fluxo a ser testado do sistema
 * @author Thiago Carreira A. Nascimento
 */

public class LoginAction {

    private AppiumDriver<MobileElement> driver;
    private LoginObj loginObj;
    private String user, senha;

    public LoginAction(AppiumDriver<MobileElement> driver, String user, String senha){
        this.driver = driver;
        this.user = user;
        this.senha = senha;
    }

    public void logar(){

        loginObj.loginButton.click();
        loginObj.signInTextField.setValue(this.user);

        /* continuar fluxos -> fazer fluxo para primeiro login de user não cadastrado; user já cadastrado, e
          e fluxos alternativos
          **/

    }


    /**
     * Método para baixar o teclado nativo do Android. Será realocado para outra
     * classe de extensions.
     */
    public void hideKeyboard() {
        ((AndroidDriver) driver).pressKeyCode(4);
    }
}