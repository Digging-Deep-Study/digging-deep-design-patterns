package ch06.editor;

import ch06.editor.command.Command;

import java.util.ArrayDeque;
import java.util.Deque;

//명령 실행 및 히스토리 관리
public class CommandManager {

  private final Deque<Command> undoStack = new ArrayDeque<>();
  private final Deque<Command> redoStack = new ArrayDeque<>();

  //명령 실행, Undo 스택에 보관하고 Redo 스택 초기화
  public void executeCommand(Command cmd) {
    cmd.execute();
    undoStack.push(cmd);
    redoStack.clear();
  }

  //마지막 명령 취소
  public void undo() {
    if (!undoStack.isEmpty()) {
      Command cmd = undoStack.pop();
      cmd.undo();
      redoStack.push(cmd);
    }
  }

  //마지막 취소 명령 다시 실행
  public void redo() {
    if (!redoStack.isEmpty()) {
      Command cmd = redoStack.pop();
      cmd.execute();
      undoStack.push(cmd);
    }
  }
}
