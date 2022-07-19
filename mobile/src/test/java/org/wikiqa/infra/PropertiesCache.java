package org.wikiqa.infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {
    //List<String> files = Files.readAllLines(Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("LogDate.properties")).toURI()));

    private final Properties properties = new Properties();

    private PropertiesCache()  {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("LogDate.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
