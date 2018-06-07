package pl.easlyautomate.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import pl.easlyautomate.model.ConfigurationMap;
import pl.easlyautomate.model.InitProcessModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JSONLoader {
    public static ConfigurationMap LoadConfigurationData(String Path) throws IOException {
        ConfigurationMap configuration = ConfigurationMap.initializeConfigurationMap();
        try{
            ObjectReader mapper = new ObjectMapper().readerFor(InitProcessModel.class);
            InputStream input = new FileInputStream(Path);
            InitProcessModel initProcessModel = mapper.readValue(input);
            configuration.put("configuration",initProcessModel);
            input.close();
        }catch (IOException e){
            throw e;
        }
        return configuration;
    }
}
