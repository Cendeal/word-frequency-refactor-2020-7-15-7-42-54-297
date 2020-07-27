public class Word {
    private final String value;
    private final int count;

    public Word(String word, int count) {
        this.value = word;
        this.count = count;
    }

    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }
}
