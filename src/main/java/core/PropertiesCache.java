package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {

    private Properties configNames = new Properties();
    private Properties configSonames = new Properties();
    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache() {
        InputStream names = this.getClass().getClassLoader().getResourceAsStream("names.properties");
        try {
            configNames.load(names);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        InputStream sonames = this.getClass().getClassLoader().getResourceAsStream("sonames.properties");
        try {
            configSonames.load(sonames);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String getPropertyName(String key) {
        return INSTANCE.configNames.getProperty(key);
    }
    public static String getPropertySoname(String key) {
        return INSTANCE.configSonames.getProperty(key);
    }
}
