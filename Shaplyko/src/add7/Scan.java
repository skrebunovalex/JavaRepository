package add7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scan {
    public static final char[] CONSONANT = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬбвгджзйклмнпрстфхцчшщьъ".toCharArray();
    public static final char[] VOWEL = "АЕЁИОУЫЭЮЯаеёиоуыэюя".toCharArray();
    public static final String FOR_SEPARATE_SENTENCE = "[А-Я][^!?.]+[!?.]+";

    public static int numberConsonant(String str) {
        int countConsonant = 0;
        char[] suppose = str.toCharArray();
        for (int i = 0; i < suppose.length; ++i) {
            for (int j = 0; j < CONSONANT.length; j++) {
                if (suppose[i] == CONSONANT[j]) {
                    countConsonant++;
                }
            }
        }
        return countConsonant;
    }

    public static int numberVowel(String str) {
        int countVowel = 0;

        char[] suppose = str.toCharArray();
        for (int i = 0; i < suppose.length; ++i) {
            for (int j = 0; j < VOWEL.length; j++) {
                if (suppose[i] == VOWEL[j]) {
                    countVowel++;
                }
            }
        }
        return countVowel;
    }

    public void separateSentence(String str) {
        Pattern pattern = Pattern.compile(FOR_SEPARATE_SENTENCE);
        Matcher matcher = pattern.matcher(str);
        StringBuilder newProffer = new StringBuilder();
        while (matcher.find()) {
            newProffer.append(matcher.group());
            newProffer.append(" Символов: ");
            newProffer.append(matcher.end() - matcher.start());
            newProffer.append("\n");
        }
        System.out.println(newProffer);
    }

    public int numberSpace(String str) {
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(str);
        int numberSpace = 0;
        while (matcher.find()) {
            numberSpace++;
        }
        return numberSpace;
    }

    public int numberParagraph(String str) {
        Pattern pattern = Pattern.compile("\\n+");
        Matcher matcher = pattern.matcher(str);
        int numberParagraph = 0;
        while (matcher.find()) {
            numberParagraph++;
        }
        return numberParagraph;
    }

    public void deleteSpace(String str) {
        System.out.println(str.replaceAll(" +", ""));
    }
}

