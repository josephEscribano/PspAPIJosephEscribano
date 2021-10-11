package config;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class ConfigurationSingleton_Client {
    private static ConfigurationSingleton_Client configClient;

    private String path_base;

    private ConfigurationSingleton_Client() {
    }

    public static synchronized ConfigurationSingleton_Client getInstance(){
        if (configClient == null){
            try{
                Yaml yaml = new Yaml();
                Iterable<Object> it;
                it = yaml.loadAll(new FileInputStream("config/config.yaml"));

                Map<String,String> mp = (Map) it.iterator().next();
                configClient = new ConfigurationSingleton_Client();
                configClient.setPath_base(mp.get("path_base"));

            }catch (FileNotFoundException e){
                Logger.getLogger(ConfigurationSingleton_Client.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return configClient;
    }

    private void setPath_base(String path_base) {
        this.path_base = path_base;
    }


}
