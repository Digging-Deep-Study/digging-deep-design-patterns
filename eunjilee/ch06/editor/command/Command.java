package ch06.editor.command;

public interface Command {
  void execute();

  void undo();
}
