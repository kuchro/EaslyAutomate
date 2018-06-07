package pl.easlyautomate.base;

import pl.easlyautomate.model.Configuration;

import java.io.FileNotFoundException;

public class ConfigurationLoader {
    private static Configuration configuration;
    private static ConfigurationLoader configurationLoader;

    public ConfigurationLoader() {
    }


    public static Configuration getEnvConfiguration() {
        try {
            configuration = getCurrentEnvConfiguration();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return configuration;
    }

    private static ConfigurationReader getConfigurationReader(){
        return ConfigurationReader.getConfigurationReader();
       }

    private static Configuration getCurrentEnvConfiguration() throws FileNotFoundException {
               configuration = getConfigurationReader().ReadConfiguration().
                       get("configuration").
                       getConfiguration().
                       get(System.getProperty("prop.env"));
           return configuration;
       }

}
