package FichaTecnica.Automacao.Resources;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapsSelenium {
	
	
	DesiredCapabilities caps = new DesiredCapabilities();

	WebDriver driver = null;
	
	
	public CapsSelenium(String driver) {
		setUp(driver);
	}
	
	public DesiredCapabilities setUp(String driver) {
		
		if(driver.equalsIgnoreCase("chrome")) {
			this.caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		} else if(driver.equalsIgnoreCase("firefox")) {
			this.caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		} else {
			System.out.println("nao identificado"); //colocar uma exception no lugar
		}
		
		this.caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		this.caps.setCapability(CapabilityType.PLATFORM, Platform.LINUX); //pra rodar em container
		return caps;
		
	}
	
	public DesiredCapabilities getCaps() {
		return this.caps;
	}

}
