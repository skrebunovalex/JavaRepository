package work.laba5;

//5.	В каждом предложении текста поменять местами первое слово с последним не изменяя длины предложения.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceFirstAndLastWordInSentence {
    private static final String REGEX_SENTENCE = "[A-ZА-Я0-9][^.?!]+[.?!]+";
    private static final Pattern PATTERN_SENTENCE = Pattern.compile(REGEX_SENTENCE);
    private static final String REGEX_FOR_SPLIT_PUNCTUATION = "\\p{Punct}";

    public static String replaceWordInSentence(String str) {
        Matcher matcher = PATTERN_SENTENCE.matcher(str);
        int sizeArray = str.split(REGEX_SENTENCE).length;
        String[] arrayOriginalSentence = new String[sizeArray];
        String[] arrayChangeableSentence = new String[sizeArray];
        int numberOfSentence = 0;
        while (matcher.find()) {
            arrayOriginalSentence[numberOfSentence] = matcher.group();
            arrayChangeableSentence[numberOfSentence] = getChangeSentence(arrayOriginalSentence[numberOfSentence]);
            numberOfSentence++;
        }
        return getString(str, arrayOriginalSentence, arrayChangeableSentence, numberOfSentence);
    }

    private static String getString(String str, String[] arrayOriginalSentence,
                                    String[] arrayChangeableSentence, int numberOfSentence) {
        for (int i = 0; i < numberOfSentence; i++) {
            str = str.replace(arrayOriginalSentence[i], arrayChangeableSentence[i]);
        }
        return str;
    }

    private static String getChangeSentence(String sentence) {
        String[] arrayWord = sentence.split(" +");
        String firstWord = buildWordWithPunctuation(arrayWord[0], arrayWord[arrayWord.length - 1]);
        String lastWord = buildWordWithPunctuation(arrayWord[arrayWord.length - 1], arrayWord[0]);
        sentence = sentence.replaceFirst(arrayWord[arrayWord.length - 1], lastWord);
        sentence = sentence.replaceFirst(arrayWord[0], firstWord);
        return sentence;
    }

    private static String buildWordWithPunctuation(String startWord, String endWord) {
        return startWord.replace(startWord.split(REGEX_FOR_SPLIT_PUNCTUATION)[0], endWord.split(REGEX_FOR_SPLIT_PUNCTUATION)[0]);
    }
}
