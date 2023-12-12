package assessment.Controler;
import assessment.WordCounter;
import assessment.domain.WordRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController

public class WordCountController {
    @PostMapping(value="/word")
    public String requestLoan(@RequestBody WordRequest wordRequest) throws IOException, InterruptedException {
        String outPut =  WordCounter.addOneOrMoreWords(wordRequest.getsubmitedWord());
        return outPut;


    }
}

