package com.project.LearnLynks.dtos.response;

import com.project.LearnLynks.models.TriviaQuestion;

public class TriviaApiResponse {
    private TriviaQuestion[] results;

    public TriviaQuestion[] getResults() {
        return results;
    }

    public void setResults(TriviaQuestion[] results) {
        this.results = results;
    }
}
