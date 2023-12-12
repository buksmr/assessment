package assessment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WordRequest {
    public String getsubmitedWord() {
        return submitedWord;
    }
    private String submitedWord;
}