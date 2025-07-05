package ch09.composite;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CompositePatternIntegrationTest {
    
    private Folder root;
    private Folder documents;
    private Folder images;
    private Folder work;
    private File reportFile;
    private File presentationFile;
    private File photoFile;
    private File projectFile;
    
    @BeforeEach
    void setUp() {
        // 테스트용 파일시스템 구조 생성
        root = new Folder("Root");
        documents = new Folder("Documents");
        images = new Folder("Images");
        work = new Folder("Work");
        
        reportFile = new File("report.txt", "This is a sample report content");
        presentationFile = new File("presentation.pptx", "Presentation content here");
        photoFile = new File("photo1.jpg", "Image data 1");
        projectFile = new File("project.txt", "Project documentation");
        
        // 구조 구성
        work.add(projectFile);
        documents.add(reportFile);
        documents.add(presentationFile);
        documents.add(work);
        images.add(photoFile);
        root.add(documents);
        root.add(images);
    }
    
    @Test
    @DisplayName("파일시스템 구조 테스트")
    void testFileSystemStructure() {
        assertEquals("Root", root.getName());
        assertEquals("Documents", documents.getName());
        assertEquals("Images", images.getName());
        assertEquals("Work", work.getName());
    }
    
    @Test
    @DisplayName("각 폴더의 항목 수 테스트")
    void testFileSystemItemCount() {
        assertEquals(2, root.getChildren().size()); // documents, images
        assertEquals(3, documents.getChildren().size()); // report, presentation, work
        assertEquals(1, images.getChildren().size()); // photo
        assertEquals(1, work.getChildren().size()); // project
    }
    
    @Test
    @DisplayName("display() 메서드 테스트")
    void testDisplayOutput() {
        // System.out을 캡처하기 위한 설정
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        try {
            root.display("");
            String output = outputStream.toString();
            
            // 출력에 폴더와 파일이 포함되어 있는지 확인
            assertTrue(output.contains("L Root"));
            assertTrue(output.contains("L Documents"));
            assertTrue(output.contains("L Images"));
            assertTrue(output.contains("L Work"));
            assertTrue(output.contains("- report.txt"));
            assertTrue(output.contains("- presentation.pptx"));
            assertTrue(output.contains("- photo1.jpg"));
            assertTrue(output.contains("- project.txt"));
            
            // 크기 정보가 포함되어 있는지 확인
            assertTrue(output.contains("bytes"));
            assertTrue(output.contains("items"));
            
        } finally {
            System.setOut(originalOut);
        }
    }
    
} 