package ch06.editor.command;

import ch06.editor.TextEditor;

public class CutCommand implements Command {
  private final TextEditor editor;
  private final int start;
  private final int end;
  private String backupContent;
  private String backupClipboard;

  public CutCommand(TextEditor editor, int start, int end) {
    this.editor = editor;
    this.start = start;
    this.end = end;
  }

  @Override
  public void execute() {
    backupContent = editor.getContent();
    backupClipboard = editor.getClipboard();
    editor.cut(start, end);
  }

  @Override
  public void undo() {
    editor.setContent(backupContent);
    editor.setClipboard(backupClipboard);
  }
}
