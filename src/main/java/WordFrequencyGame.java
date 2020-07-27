import java.util.*;

public class WordFrequencyGame {

    public static final String BLANK_PATTERN = "\\s+";
    public static final String NEW_LINE_DELIMITER = "\n";
    public static final String CALCULATE_ERROR = "Calculate Error";

    public String getResult(String sentence) {


        if (sentence.split(BLANK_PATTERN).length == 1) {
            return sentence + " 1";
        } else {

            try {

                String[] words = sentence.split(BLANK_PATTERN);

                List<Word> inputList = new ArrayList<>();
                for (String s : words) {
                    Word input = new Word(s, 1);
                    inputList.add(input);
                }

                Map<String, List<Word>> map = getListMap(inputList);

                List<Word> list = new ArrayList<>();
                for (Map.Entry<String, List<Word>> entry : map.entrySet()) {
                    Word input = new Word(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

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
    }

    private Map<String, List<Word>> getListMap(List<Word> inputList) {
        Map<String, List<Word>> map = new HashMap<>();
        for (Word input : inputList) {
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
