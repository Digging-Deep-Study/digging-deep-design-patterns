package ch03.request;

import java.util.Objects;

public class RequestURL {
    private final String url;
    private static final String REGEXP_URL = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#()?&//=]*)";

    public RequestURL(String url) {
        if (!url.matches(REGEXP_URL)) throw new IllegalArgumentException("invalid request URL");

        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestURL that = (RequestURL) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

    @Override
    public String toString() {
        return "RequestURL{" +
                "url='" + url + '\'' +
                '}';
    }
}
