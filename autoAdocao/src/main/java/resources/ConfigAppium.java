package resources;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.MalformedParametersException;



/**
 * Classe em que constam as configuracoes para o servidor appium
 * @author Thiago Carreira A. Nascimento
 * @version 0.1
 *
 */

public class ConfigAppium {

    private DesiredCapabilities cap = new DesiredCapabilities();

    /**
     *
     * Metodo que define as configuracoes de execucao para o Appium
     * @author Thiago Carreira A. Nascimento
     * @param device: tipo/avd ou udid do device em que o teste vai ser executado
     */
    public ConfigAppium(String device, String tipoDevice, String appName) {
        setUpCap(device, tipoDevice, appName);
    }

    private DesiredCapabilities setUpCap(String device, String tipoDevice, String appName) { //verificar com parâmetros do inspector

        if(tipoDevice.equalsIgnoreCase("iOS")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        } else if(tipoDevice.equalsIgnoreCase("Android")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        } else {
            throw new MalformedParametersException("Plataforma não identificada");
        }

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.APP, appName); //rever possibilidade de passar como parâmetro também
        cap.setCapability(MobileCapabilityType.UDID, device);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10"); //timeout
        cap.setCapability(MobileCapabilityType.NO_RESET, "true");

        //	cap.setCapability("unicodeKeyboard", false);

        //	cap.setCapability("resetKeyboard", false);

        return cap;
    }

    public DesiredCapabilities getCap() {
        return this.cap;
    }
}
