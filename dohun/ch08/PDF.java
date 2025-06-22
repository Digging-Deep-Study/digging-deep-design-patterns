package ch08;

public class PDF extends Document {
    @Override
    void createHeader() {
        System.out.println("PDF Header");
    }

    @Override
    void createBody() {
        System.out.println("PDF Body");
    }

    @Override
    void createFooter() {

    }

    @Override
    boolean haveHeader() {
        return true;
    }
}
