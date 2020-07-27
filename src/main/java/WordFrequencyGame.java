import java.util.*;

public class WordFrequencyGame {

    public static final String BLANK_PATTERN = "\\s+";
    public static final String NEW_LINE_DELIMITER = "\n";
    public static final String CALCULATE_ERROR = "Calculate Error";

    public String getResult(String sentence) {
        try {
            List<Word> inputList = calculateWordFrequency(sentence);
            inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner(NEW_LINE_DELIMITER);
            for (Word w : inputList) {
                String s = w.getValue() + " " + w.getWordCount();
                joiner.add(s);
            }
            return joiner.toString();
        } catch (Exception e) {
            return CALCULATE_ERROR;
        }

    }

    private List<Word> calculateWordFrequency(String sentence) {
        List<Word> wordCalculateResult = new ArrayList<>();
        List<String> words = Arrays.asList(sentence.split(BLANK_PATTERN));
        new HashSet<>(words).forEach((uniqueWord) -> {
            wordCalculateResult.add(new Word(uniqueWord, (int) words.stream().filter(uniqueWord::equals).count()));
        });
        return wordCalculateResult;
    }
}
