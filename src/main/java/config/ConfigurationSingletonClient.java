package config;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class ConfigurationSingletonClient {
    private static ConfigurationSingletonClient configClient;

    private String pathbase;

    private ConfigurationSingletonClient() {
    }

    public static synchronized ConfigurationSingletonClient getInstance(){
        if (configClient == null){
            try{
                Yaml yaml = new Yaml();
                Iterable<Object> it;
                it = yaml.loadAll(new FileInputStream("config/config.yaml"));

                Map<String,String> mp = (Map) it.iterator().next();
                configClient = new ConfigurationSingletonClient();
                configClient.setPathbase(mp.get("path_base"));

            }catch (FileNotFoundException e){
                Logger.getLogger(ConfigurationSingletonClient.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return configClient;
    }

    private void setPathbase(String pathbase) {
        this.pathbase = pathbase;
    }


}
