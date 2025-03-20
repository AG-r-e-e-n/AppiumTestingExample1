package Enviroment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvLoader {
    private final Properties properties;

    public EnvLoader(String filePath) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(filePath);
        properties.load(fis);
        fis.close();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}