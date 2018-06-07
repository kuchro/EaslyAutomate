package pl.easlyautomate.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import pl.easlyautomate.base.ConfigurationLoader;
import pl.easlyautomate.model.Configuration;
import static pl.easlyautomate.util.StaticData.*;


public class Initializer {
    private static Initializer init;
    private static Configuration configuration;
    private static WebDriver iWebdriver;

    public static Initializer getInstance() {
        if(init==null) {
            init = new Initializer();
        }
        return init;
    }

    public void initConfiguration(){
     configuration = ConfigurationLoader.getEnvConfiguration();
    }

    public void startBrowser() {

        try {
            switch (configuration.getBrowserName().toLowerCase()) {
                case CHROME:
                case CHROME_DRIVER:
                    iWebdriver = new ChromeDriver();
                    break;
                case FIREFOX:
                case GECKO_DRIVER:
                case MOZILLA:
                    iWebdriver = new FirefoxDriver();
                    break;
                case IE:
                case IE_DRIVER:
                    iWebdriver = new InternetExplorerDriver();
                    break;
                case SAFARI:
                case SAFARI_DRIVER:
                    iWebdriver = new SafariDriver();
                    break;
                case OPERA:
                case OPERA_DRIVER:
                    iWebdriver = new OperaDriver();
                    break;
                default:
                    throw new NullPointerException();
            }
        }catch(NullPointerException e){
            throw new NullPointerException("In configuration file browserName has null. Please set browser/driver name.");
    }
    }

    private Initializer() {
        initConfiguration();
        CoreMethodsImpl coreMethodsImpl = new CoreMethodsImpl();
    }

    public WebDriver getDriver(){
        return iWebdriver;
    }
}
