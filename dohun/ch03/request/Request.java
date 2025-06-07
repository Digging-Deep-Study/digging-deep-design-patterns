package ch03.request;

public class Request {
    private RequestURL url;
    private String id;
    private String data;
    private RequestMethod method;
    private RequestAddr requestAddr;

    public Request(RequestURL url, String id, String data, RequestMethod method, RequestAddr requestAddr) {
        this.url = url;
        this.id = id;
        this.data = data;
        this.method = method;
        this.requestAddr = requestAddr;
    }

    public RequestURL getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public RequestAddr getRequestAddr() {
        return requestAddr;
    }
}
