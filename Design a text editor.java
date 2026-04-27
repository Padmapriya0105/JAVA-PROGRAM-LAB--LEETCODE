class TextEditor {
    private StringBuilder left = new StringBuilder();
    private StringBuilder right = new StringBuilder();

    public TextEditor() {}

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleted = Math.min(k, left.length());
        left.setLength(left.length() - deleted);
        return deleted;
    }

    public String cursorLeft(int k) {
        int move = Math.min(k, left.length());
        for (int i = 0; i < move; i++) {
            right.append(left.charAt(left.length() - 1));
            left.setLength(left.length() - 1);
        }
        return getLeftText();
    }

    public String cursorRight(int k) {
        int move = Math.min(k, right.length());
        for (int i = 0; i < move; i++) {
            left.append(right.charAt(right.length() - 1));
            right.setLength(right.length() - 1);
        }
        return getLeftText();
    }

    private String getLeftText() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start);
    }
}
