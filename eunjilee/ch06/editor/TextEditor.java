package ch06.editor;

public class TextEditor {
  private StringBuilder content = new StringBuilder();
  private String clipboard = "";

  public void setContent(String text) {
    content = new StringBuilder(text);
  }

  public String getContent() {
    return content.toString();
  }

  public void cut(int start, int end) {
    clipboard = content.substring(start, end);
    content.delete(start, end);
  }

  public void paste(int position) {
    content.insert(position, clipboard);
  }

  public String getClipboard() {
    return clipboard;
  }

  public void setClipboard(String text) {
    clipboard = text;
  }
}
