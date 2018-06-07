package pl.easlyautomate.util;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import pl.easlyautomate.model.ConfigurationMap;
import pl.easlyautomate.model.InitProcessModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class YamlLoader {
    public static ConfigurationMap LoadConfigurationData(String Path) throws IOException {
        Constructor constructor = new Constructor(InitProcessModel.class);
        Yaml yaml = new Yaml();
        ConfigurationMap configuration = ConfigurationMap.initializeConfigurationMap();
        try (InputStream input = new FileInputStream(Path)) {
            InitProcessModel model = yaml.loadAs(input, InitProcessModel.class);
            configuration.put("configuration",model);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return  configuration;
    }
}
