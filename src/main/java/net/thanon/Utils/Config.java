package net.thanon.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public String cfgName;
    public Properties inputMoney;
    public File cfg;
    public Config(String path, String configName) {
        configName = this.cfgName;
        cfg = new File(path, cfgName);
        try {
            if(!cfg.exists()) {
                cfg.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void set(String key, String set) {
        try(FileReader reader = new FileReader(cfgName)) {
            inputMoney = new Properties();
            inputMoney.load(reader);
            inputMoney.setProperty(key, set);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
