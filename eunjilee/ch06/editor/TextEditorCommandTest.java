package ch06.editor;

import ch06.editor.command.CutCommand;
import ch06.editor.command.PasteCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEditorCommandTest {
  private TextEditor editor;
  private CommandManager manager;

  @BeforeEach
  void setUp() {
    editor = new TextEditor();
    manager = new CommandManager();
    editor.setContent("Hello, World!");
  }

  @Test
  void testCutAndUndo() {
    CutCommand cut = new CutCommand(editor, 7, 12);
    manager.executeCommand(cut);
    assertEquals("Hello, !", editor.getContent());
    manager.undo();
    assertEquals("Hello, World!", editor.getContent());
  }

  @Test
  void testPasteAndUndoRedo() {
    CutCommand cut = new CutCommand(editor, 7, 12);
    manager.executeCommand(cut);
    PasteCommand paste = new PasteCommand(editor, 0);
    manager.executeCommand(paste);
    assertEquals("WorldHello, !", editor.getContent());

    manager.undo();
    assertEquals("Hello, !", editor.getContent());

    manager.undo();
    assertEquals("Hello, World!", editor.getContent());

    manager.redo();
    assertEquals("Hello, !", editor.getContent());
  }
}
