package ch03.request;

public class RequestAddr {
    private final String addr;
    public static final String REGEXP_IPV4_ADDR = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    public RequestAddr(String addr) {
        if (!addr.matches(REGEXP_IPV4_ADDR)) throw new IllegalArgumentException("invalid IPv4 address");

        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }
}
