package ch05.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationManagerTest {
  private ConfigurationManager manager;

  @BeforeEach
  void setUp() {
    System.clearProperty("phase");
    manager = ConfigurationManager.getInstance();
  }

  @Test
  void testSingletonInstance() {
    final ConfigurationManager instance1 = ConfigurationManager.getInstance();
    final ConfigurationManager instance2 = ConfigurationManager.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  void testDefaultPhaseLocal() {
    final DbConfig db = manager.getDbConfig();
    assertEquals("jdbc:mysql://localhost:3306/localdb", db.url());
    assertEquals("localuser", db.username());
    assertEquals("localpass", db.password());
  }

  @Test
  void testDevelopmentPhase() {
    System.setProperty("phase", "development");
    final DbConfig db = manager.getDbConfig();
    assertEquals("jdbc:mysql://dev-server:3306/devdb", db.url());
    assertEquals("devuser", db.username());
    assertEquals("devpass", db.password());
  }

  @Test
  void testUnknownPhaseThrows() {
    System.setProperty("phase", "staging");
    assertThrows(IllegalArgumentException.class, () -> manager.getDbConfig());
  }
}
