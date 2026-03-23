package chapter_06_oop_principles.document_editor;

import java.util.Stack;

public class Document {
    private final StringBuilder textStringBuilder;
    private final Stack<String> history = new Stack<>();

    public Document() {
        this.textStringBuilder = new StringBuilder();
    }

    public StringBuilder getTextStringBuilder() {
        return new StringBuilder(textStringBuilder.toString());
    }

    public void appendText(String text) {
        history.push(textStringBuilder.toString());
        textStringBuilder.append(text);
    }

    public String undo() {
        if (history.isEmpty()) {
            return "Отменять нечего";
        } else {
            String oldText = history.pop();
            textStringBuilder.setLength(0);
            textStringBuilder.append(oldText);
            return textStringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        return textStringBuilder.toString();
    }
}