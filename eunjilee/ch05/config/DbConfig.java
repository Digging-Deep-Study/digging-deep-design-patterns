package ch05.config;

public record DbConfig(
                String url,
                String username,
                String password) {
}
