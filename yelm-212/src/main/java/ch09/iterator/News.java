package ch09.iterator;

public class News {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "-- News --\n" +
                "[title=" + title + ", content=" + content + "] \n";
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
