package classWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Вывести все предложения заданного текста в порядке
//возрастания количества слов в каждом из них

public class TextSplitter {
    private final String sentenceMarkRegEx = "[.!?]";
    private final String spaceRegEx = "[ ]";

    public int countSentences(String string) {
        return string.split(sentenceMarkRegEx).length;
    }

    public int countWords(String sentence) {
        return sentence.split(spaceRegEx).length;
    }

    public String obtainSentence(String string, int sentenceIndex) {
        Pattern pattern = Pattern.compile(sentenceMarkRegEx);
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder();
        int currentPosition = 0;
        int iterator = 0;
        while (matcher.find(currentPosition)) {
            if (sentenceIndex == iterator) {
                stringBuilder.append(string.substring(currentPosition, matcher.end()));
                while (stringBuilder.charAt(0) == ' ') {
                    stringBuilder.deleteCharAt(0);
                }
            }
            iterator++;
            currentPosition = matcher.end();
        }
        return stringBuilder.toString();
    }

    public String[] obtainSentences(String string) {
        Pattern pattern = Pattern.compile(sentenceMarkRegEx);
        Matcher matcher = pattern.matcher(string);
        String[] auxiliaryString = string.split(sentenceMarkRegEx);
        StringBuilder[] sentenceBuilder = new StringBuilder[auxiliaryString.length];

        int currentPosition = 0;
        int iterator = 0;
        while (matcher.find(currentPosition)) {
            sentenceBuilder[iterator] = new StringBuilder(string.substring(currentPosition, matcher.end()));
            while (sentenceBuilder[iterator].charAt(0) == ' ') {
                sentenceBuilder[iterator].deleteCharAt(0);
            }
            iterator++;
            currentPosition = matcher.end();
        }
        String[] str = new String[sentenceBuilder.length];
        for (int i = 0; i < sentenceBuilder.length; i++) {
            str[i] = sentenceBuilder[i].toString();
        }
        return str;
    }
}