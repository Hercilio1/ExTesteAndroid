package appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author thiago.nascimento@acad.pucrs.br
 * Classe dos objetos operados no login do App, criada com AppiumFieldDecorator.
 * Para maiores informações, consultar documentação oficial:
 * {link: https://appium.github.io/java-client/io/appium/java_client/pagefactory/AppiumFieldDecorator.html}
 */

public class LoginObj {

    /**
     * @param driver {link appium.github.io/java-client/io/appium/java_client/AppiumDriver.html}
     * @author thiago.nascimento@acad.pucrs.br
     */

    public LoginObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="com.euquero.trocas:id/sign_in_button")
    public MobileElement loginButton; //login pelo gmail

    @AndroidFindBy(id="identifierId")
    public MobileElement signInTextField;

    @AndroidFindBy(id="identifierNext")
    public MobileElement identifiernextButton;

    @AndroidFindBy(id="com.google.android.gms:id/title")
    public MobileElement chooseAccountLabel;

    @AndroidFindBy(id="android:id/button2")
    public MobileElement addAccountButton;

    @AndroidFindBy(id="passwordNext")
    public MobileElement passNextButton;

    @AndroidFindBy(id="signinconsentNext")
    public MobileElement agreeButton;

    @AndroidFindBy(id="com.euquero.trocas:id/register_cpf")
    public MobileElement cpfTextField;

    @AndroidFindBy(id="com.euquero.trocas:id/register_checkbox_adult")
    public MobileElement maiorCheckBox;

    @AndroidFindBy(id="com.euquero.trocas:id/register_phone")
    public MobileElement telefoneTextField;

    @AndroidFindBy(id="com.euquero.trocas:id/register_checkbox_phone")
    public MobileElement exibirTelefoneCheckBox;

    @AndroidFindBy(id="com.euquero.trocas:id/register_spinner_uf")
    public MobileElement clicaExibirUF;

    /**
     * verificar como abrir lista de UF, porque aparentemente fica oculta. Pode-se clicar para abri-la,
     * e, dado a coordenadas, checar se há um item da lista que corresponda ao desejado.
     */
//    @AndroidFindBy(className = "android.widget.ListView")
//    public MobileElement listaUF;

    @AndroidFindBy(id="com.euquero.trocas:id/register_city")
    public MobileElement cidadeTextField;

    @AndroidFindBy(id="com.euquero.trocas:id/register_button_register")
    public MobileElement finalizarCadastroButton;

}