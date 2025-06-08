package ch05.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

// 애플리케이션 전역 설정을 관리하는 싱글턴 클래스
public class ConfigurationManager {
  private static final String CONFIG_RESOURCE = "application.yml";
  private final AppConfig config;

  private ConfigurationManager() {
    this.config = loadConfig();
  }

  private static class Holder {
    private static final ConfigurationManager INSTANCE = new ConfigurationManager();
  }

  public static ConfigurationManager getInstance() {
    return Holder.INSTANCE;
  }

  private AppConfig loadConfig() {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    try (InputStream is = getClass().getClassLoader().getResourceAsStream(CONFIG_RESOURCE)) {
      Objects.requireNonNull(is, CONFIG_RESOURCE + " not found on classpath");
      return mapper.readValue(is, AppConfig.class);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load config [" + CONFIG_RESOURCE + "]", e);
    }
  }

  public DbConfig getDbConfig() {
    String phase = System.getProperty("phase");
    if (phase == null || phase.isBlank()) {
      phase = config.phase();
    }
    DbConfig dbConfig = config.db().get(phase);
    if (dbConfig == null) {
      throw new IllegalArgumentException("Unknown phase: " + phase);
    }
    return dbConfig;
  }
}
