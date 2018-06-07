package pl.easlyautomate.core;

import org.openqa.selenium.WebDriver;

//still need to implement this logic, which will implement CoreMethods interface
public class CoreMethodsImpl  {
    private WebDriver driver;
    public CoreMethodsImpl(Initializer driver){
        this.driver = driver.getDriver();
    }

    public CoreMethodsImpl(){

    }

}
