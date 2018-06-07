package pl.easlyautomate.model;

import java.util.Map;

public class Configuration {

    private String browserName;
    private String urladdress;
    private FilePaths filePaths;
    private Map<String,DataBaseData> dataBase;
    private Map<String,ServersData> serversData;

    public Configuration() {
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress;
    }

    public FilePaths getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(FilePaths filePaths) {
        this.filePaths = filePaths;
    }

    public Map<String, DataBaseData> getDataBase() {
        return dataBase;
    }

    public void setDataBase(Map<String, DataBaseData> dataBase) {
        this.dataBase = dataBase;
    }

    public Map<String, ServersData> getServersData() {
        return serversData;
    }

    public void setServersData(Map<String, ServersData> serversData) {
        this.serversData = serversData;
    }
}
