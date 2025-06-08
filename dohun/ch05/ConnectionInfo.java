package ch05;

public enum ConnectionInfo {
    driver("org.postgresql.Driver"),
    url("jdbc:postgresql://localhost:5432/postgres"),
    username("admin"),
    password("1234");

    String value;

    ConnectionInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
