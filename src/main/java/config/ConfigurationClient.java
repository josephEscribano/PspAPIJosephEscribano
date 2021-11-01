package config;

import lombok.Getter;
import org.yaml.snakeyaml.Yaml;
import utils.Constantes;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@Getter
@Singleton
public class ConfigurationClient {


    private final String pathbase;

    public ConfigurationClient() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Iterable<Object> it;
        it = yaml.loadAll(new FileInputStream("config/config.yaml"));

        Map<String, String> mp = (Map) it.iterator().next();
        this.pathbase = mp.get(Constantes.PATH_BASE);

    }


}
