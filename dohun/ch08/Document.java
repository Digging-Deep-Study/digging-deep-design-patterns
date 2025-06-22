package ch08;

public abstract class Document {

    final void createDocument() {
        if (haveHeader()) createHeader();

        createBody();

        if (haveFooter()) createFooter();
    }

    abstract void createHeader();
    abstract void createBody();
    abstract void createFooter();

    // hook
    boolean haveHeader() {
        return false;
    }

    // hook
    boolean haveFooter() {
        return false;
    }

}
