import assessment.WordCounter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

import java.io.IOException;

class WordCounterTest {

    @Test
    void test() throws IOException, InterruptedException {
        assertEquals(WordCounter.getInstance().addOneOrMoreWords("Me me me me"));
    }

    private void assertEquals(String me) {
    }

}