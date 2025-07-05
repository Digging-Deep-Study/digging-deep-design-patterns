package me.sungbin.chapter.composite;

public class Main {

    public static void main(String[] args) {
        FileSystemManager fileSystem = createSampleFileSystem();

        fileSystem.displayFileSystem();

        fileSystem.printStatistics();

        System.out.println("\n 검색 결과:");
        testSearch(fileSystem, "resume.pdf");
        testSearch(fileSystem, "projects");
        testSearch(fileSystem, "nonexistent.txt");
    }

    private static FileSystemManager createSampleFileSystem() {
        FileSystemManager fileSystem = new FileSystemManager("MyComputer");
        Folder root = fileSystem.getRootFolder();

        Folder documents = new Folder("Documents");
        documents.add(new File("resume.pdf", 2048000)); // 2MB
        documents.add(new File("cover_letter.docx", 51200)); // 50KB

        Folder pictures = new Folder("Pictures");
        pictures.add(new File("vacation.jpg", 5242880)); // 5MB
        pictures.add(new File("family.png", 3145728)); // 3MB

        Folder vacation = new Folder("vacation");
        vacation.add(new File("beach.jpg", 2097152)); // 2MB
        vacation.add(new File("mountain.jpg", 1572864)); // 1.5MB
        pictures.add(vacation);

        Folder projects = new Folder("projects");

        Folder javaProject = new Folder("JavaApp");
        javaProject.add(new File("Main.java", 4096)); // 4KB
        javaProject.add(new File("Utils.java", 2048)); // 2KB
        javaProject.add(new File("README.md", 1024)); // 1KB

        projects.add(javaProject);

        Folder pythonProject = new Folder("PythonScript");
        pythonProject.add(new File("app.py", 8192)); // 8KB
        pythonProject.add(new File("requirements.txt", 512)); // 512B

        projects.add(pythonProject);

        root.add(documents);
        root.add(pictures);
        root.add(projects);

        root.add(new File("system.log", 10240)); // 10KB

        return fileSystem;
    }

    private static void testSearch(FileSystemManager fileSystem, String name) {
        FileSystemComponent result = fileSystem.search(name);
        if (result != null) {
            System.out.printf("Found: %s%n", result);
        } else {
            System.out.printf("Not found: %s%n", name);
        }
    }
}
