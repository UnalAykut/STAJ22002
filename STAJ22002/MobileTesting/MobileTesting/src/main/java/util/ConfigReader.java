package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigReader {
    private static Properties properties;
    private static final Logger logger = Logger.getLogger(ConfigReader.class.getName());

    public static Properties loadProperties() throws IOException {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
                properties.load(fileInputStream);
                logger.info("Config properties successfully loaded.");
            } catch (IOException e) {
                logger.severe("Failed to load config properties: " + e.getMessage());
                throw e;
            }
        }
        return properties;
    }

    public static Properties getProperties() {
        if (properties == null) {
            try {
                loadProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
