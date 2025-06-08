package ch05.config;

import java.util.Map;

public record AppConfig(
                String phase,
                Map<String, DbConfig> db) {
}
