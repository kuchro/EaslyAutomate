package pl.easlyautomate.base;

import pl.easlyautomate.model.ConfigurationMap;
import pl.easlyautomate.util.JSONLoader;
import pl.easlyautomate.util.YamlLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigurationReader {
    private static final String ConfigFilesPattern = ".*\\.(yml$|yaml$|json$)";
    private static String ConfigFilePath = System.getProperty("user.dir")+"\\";
    /*This allow us to check project dir, trying to find configuration file*/

    private static ConfigurationReader configuration;
    private static ConfigurationMap configurationMap;

    public static ConfigurationReader getConfigurationReader() {
        if(configuration ==null){
            configuration = new ConfigurationReader();
        }
        return configuration;
    }
    private ConfigurationReader(){

    }

    public ConfigurationMap ReadConfiguration() throws FileNotFoundException {
        return TryReadConfiguration();
    }

    private static ConfigurationMap TryReadConfiguration() throws FileNotFoundException {
        if(configurationMap==null) {
            try {
                File[] ConfigFiles = ReturnFileThatMatchExtension(ConfigurationReader.ConfigFilesPattern);
                configurationMap = LoadConfiguration(ConfigFiles[0]);
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return configurationMap;
    }

    private static File[] ReturnFileThatMatchExtension(String Pattern) throws FileNotFoundException {
        File currentDir = new File(ConfigFilePath);
        File[] files;
        try {
            files = currentDir.listFiles((dir, name) -> name.toLowerCase().matches(Pattern));
            CheckDir(files);
        }catch (FileNotFoundException e){
            throw e;
        }
        return files;
    }

    private static ConfigurationMap LoadConfiguration(File FileName) throws IOException {

        try{
            if(FileName.getName().matches(".*\\.(yml$|yaml$)")) {
                configurationMap = YamlLoader.LoadConfigurationData(FileName.getAbsolutePath());
            }else if (FileName.getName().matches(".*\\.(json$)")){
                configurationMap = JSONLoader.LoadConfigurationData(FileName.getAbsolutePath());
            }
        }catch (IOException e){
            throw e;
        }
        return configurationMap;
    }

    private static void CheckDir(File[] files) throws FileNotFoundException {
        if(files.length==0){
            throw new FileNotFoundException("There's no configuration file that match requirements. Please make sure that" +
                    " project dir contains file with extension: *.json or *.yaml.");
        }
    }

}
