package assessment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class WordCounter {

    private static final ArrayList<String> wordsArray = new ArrayList<String>();
    private static WordCounter single_instance = null;
    public String s;
    private WordCounter()
    {
    }
    public static synchronized WordCounter getInstance()
    {
        if (single_instance == null) {
            single_instance = new WordCounter();
        }
        return single_instance;
    }
    public String addOneOrMoreWords(String addWord )  {
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
    private static void methodCount(String word)  {
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

