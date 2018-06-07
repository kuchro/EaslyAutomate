package pl.easlyautomate.model;


import java.util.HashMap;

public class ConfigurationMap extends HashMap<String, InitProcessModel>
{
    private static ConfigurationMap ourInstance;

    public static ConfigurationMap initializeConfigurationMap(){
        return new ConfigurationMap();
    }

    private ConfigurationMap() {
    }
}
