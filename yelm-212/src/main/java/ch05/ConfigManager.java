package ch05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum ConfigManager {
    INSTANCE;

    private final Properties props;

    public String getProperty(String key) {
        if (props == null) throw new IllegalStateException("Config not initialized");
        return props.getProperty(key);
    }

    ConfigManager() {
        this.props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load config", ex);
        }
    }

}


