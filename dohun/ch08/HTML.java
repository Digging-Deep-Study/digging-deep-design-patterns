package ch08;

public class HTML extends Document {
    @Override
    void createHeader() {
        System.out.println("script, style import and configuration");
    }

    @Override
    void createBody() {
        System.out.println("<body>Hello world!</body>");
    }

    @Override
    void createFooter() {
        System.out.println("service load map, ad, Company Policy");
    }

    @Override
    boolean haveHeader() {
        return true;
    }

    @Override
    boolean haveFooter() {
        return true;
    }
}
