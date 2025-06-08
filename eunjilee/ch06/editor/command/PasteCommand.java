package ch06.editor.command;

import ch06.editor.TextEditor;

public class PasteCommand implements Command{
  private final TextEditor editor;
  private final int position;
  private String backupContent;

  public PasteCommand(TextEditor editor, int position) {
    this.editor = editor;
    this.position = position;
  }

  @Override
  public void execute() {
    backupContent = editor.getContent();
    editor.paste(position);
  }

  @Override
  public void undo() {
    editor.setContent(backupContent);
  }
}
