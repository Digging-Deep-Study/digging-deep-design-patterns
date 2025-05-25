package ch03.decorator;

public class Request {
    private String url;
    private String data;

    public Request(String url, String data) {
        this.url = url;
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Request{url='" + url + "', data='" + data + "'}";
    }
} 