package ch09.composite;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        
        Folder documents = new Folder("Documents");
        documents.add(new File("report.txt", "This is a sample report content"));
        documents.add(new File("presentation.pptx", "Presentation content here"));
        
        Folder images = new Folder("Images");
        images.add(new File("photo1.jpg", "Image data 1"));
        images.add(new File("photo2.png", "Image data 2"));
        
        Folder work = new Folder("Work");
        work.add(new File("project.txt", "Project documentation"));
        work.add(new File("todo.txt", "Todo list"));
        
        documents.add(work);
        root.add(documents);
        root.add(images);
        
        System.out.println("=== File System Structure ===");
        root.display("");
        
        System.out.println("\n=== Folder Size Information ===");
        System.out.println("Root size: " + root.getSize() + " bytes");
        System.out.println("Documents size: " + documents.getSize() + " bytes");
        System.out.println("Images size: " + images.getSize() + " bytes");
        System.out.println("Work size: " + work.getSize() + " bytes");
    }
}


