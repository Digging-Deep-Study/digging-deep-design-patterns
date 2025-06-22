package ch08;

public class Main {
    public static void main(String[] args) {

        // HTML
        Document html = new HTML();
        html.createDocument();
        System.out.println("---------------------------------------");

        // PDF
        Document pdf = new PDF();
        pdf.createDocument();
        System.out.println("---------------------------------------");

        // Markdown
        Document markdown = new Markdown();
        markdown.createDocument();

    }
}
