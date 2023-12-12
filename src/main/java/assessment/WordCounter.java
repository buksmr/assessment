package assessment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class WordCounter {

    static ArrayList<String> wordsArray = new ArrayList<String>();
    public static String addOneOrMoreWords(String addWord ) throws IOException, InterruptedException {
        String splitword[] =  addWord.split(" ");
        int count = splitword.length;
        for (int i = 0; i <count ; i++) {
            boolean isNonAlpahabet = WordCounter.checkForNonAlpahbet(splitword[i]);
            if (isNonAlpahabet)
                WordCounter.methodCount(splitword[i]);
        }
        Map<String, Long> counts = wordsArray.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counts);
        return counts.toString();
    }
    private static void methodCount(String word) throws IOException, InterruptedException {
        String translatedWord = Translator.detectWordLanguage(word);
        wordsArray.add(translatedWord);

    }
    private static boolean checkForNonAlpahbet(String word) {
        StringUtils.isAlpha(word);
        if (StringUtils.isAlpha(word)){
            return true;
        }
        return false;
    }

}

